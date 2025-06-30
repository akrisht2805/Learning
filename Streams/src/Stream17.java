import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream17 {
    public record ProjectDetail(
            String projectName,
            String owner,
            List<String> technologies // e.g. ["Java", "SpringBoot", "Kafka"]
    ) {
    }

    public static void main(String[] args) {
        List<ProjectDetail> projects = List.of(
                new ProjectDetail("Xponent", "Amit", List.of("Java", "SpringBoot", "Kafka")),
                new ProjectDetail("InternalTool", "Nina", List.of("ReactJs", "SpringBoot", "Java")),
                new ProjectDetail("RealtimeEngine", "Raj", List.of("Golang", "Kafka", "Docker"))
        );

        /**Extract a unique sorted list of all technologies used across all projects.
         * List<String> // e.g. ["Docker", "Java", "Kafka", "ReactJs", "SpringBoot"]
         * */

        System.out.println(
                projects.stream().flatMap(x -> x.technologies().stream()).distinct().toList()
        );


    }
}
