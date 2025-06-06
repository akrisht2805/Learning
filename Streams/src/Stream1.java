import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * In one of your microservices, you receive a list of Kafka messages representing user activity logs.
 * Each log contains a user ID, timestamp, and action type. You need to process this list to group actions
 * by user and get a count of each action type per user. How would you implement this using Java Streams?
 * */

public class Stream1 {

     private static class UserActivityLog {
        private String userId;
        private String actionType;
        private LocalDateTime timestamp;

        public UserActivityLog(String userId, String actionType, LocalDateTime timestamp) {
            this.userId = userId;
            this.actionType = actionType;
            this.timestamp = timestamp;
        }

        // Getters
        public String getUserId() { return userId; }
        public String getActionType() { return actionType; }
        public LocalDateTime getTimestamp() { return timestamp; }
    }


    public static void main(String[] args) {

        List<UserActivityLog> logs = Arrays.asList(
                new UserActivityLog("user1", "LOGIN", LocalDateTime.now().minusMinutes(10)),
                new UserActivityLog("user2", "LOGOUT", LocalDateTime.now().minusMinutes(5)),
                new UserActivityLog("user1", "UPLOAD", LocalDateTime.now().minusMinutes(2)),
                new UserActivityLog("user1", "LOGIN", LocalDateTime.now().minusMinutes(20)),
                new UserActivityLog("user2", "UPLOAD", LocalDateTime.now().minusMinutes(3)),
                new UserActivityLog("user2", "UPLOAD", LocalDateTime.now().minusMinutes(1)),
                new UserActivityLog("user1", "LOGOUT", LocalDateTime.now())
        );

        Map<String, Map<String,Long> > res = logs.stream().collect(Collectors.groupingBy(a->a.userId, Collectors.groupingBy(a->a.actionType, Collectors.counting())));

        for(Map.Entry<String,Map<String, Long>> entry: res.entrySet()){
            System.out.println(entry.getKey()+" -> {");
            for(Map.Entry<String,Long> en: entry.getValue().entrySet()){
                System.out.println("     "+en.getKey()+"->"+en.getValue());
            }
            System.out.println("}");
        }


    }
}