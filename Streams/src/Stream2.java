import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * You receive a list of transactions from multiple users.
 * Each transaction includes a userId, amount, and status (e.g., SUCCESS, FAILED). Using Java Streams, how would you:
 * Filter out only successful transactions,
 * Group them by userId,
 * And calculate the total transaction amount per user?
 */
public class Stream2 {

    public static class Transaction {
        private String userId;
        private double amount;
        private String status;

        // Constructor, Getters

        public Transaction(String userId, double amount, String status) {
            this.userId = userId;
            this.amount = amount;
            this.status = status;
        }

        public String getUserId() {
            return userId;
        }

        public double getAmount() {
            return amount;
        }

        public String getStatus() {
            return status;
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("user1", 200.0, "SUCCESS"),
                new Transaction("user2", 150.0, "FAILED"),
                new Transaction("user1", 100.0, "SUCCESS"),
                new Transaction("user3", 300.0, "SUCCESS"),
                new Transaction("user2", 400.0, "SUCCESS")
        );

        Map<String, Double> res = transactions.stream().filter(ele -> ele.status.equals("SUCCESS"))
                .collect(
                        Collectors.groupingBy(ele->ele.getUserId(),
                                Collectors.summingDouble(ele-> ele.getAmount())));



        res.forEach((key, val) -> {
            System.out.println(key + " -> " + val);
        });

    }
}
