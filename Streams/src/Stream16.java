import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Write Java code using Stream API to:
 * ✅ Group total hours allocated per project.
 * ✅ Find the employee(s) who worked the most total hours across all projects.
 * ✅ For a given month, list employees who worked more than 100 hours.
 * */

public class Stream16 {
    public static record ProjectAllocation (
         String employeeName,
         String projectName,
         int hoursAllocated,
         String month // format "YYYY-MM"
    ) {}


    public static void main(String[] args) {
        List<ProjectAllocation> allocations = List.of(
                new ProjectAllocation("Amit", "Xponent", 60, "2025-05"),
                new ProjectAllocation("Amit", "InternalTool", 50, "2025-05"),
                new ProjectAllocation("Nina", "Xponent", 120, "2025-05"),
                new ProjectAllocation("Raj", "InternalTool", 80, "2025-05"),
                new ProjectAllocation("Raj", "Xponent", 30, "2025-06")
        );

        Map<String,Integer> ans1 = allocations.stream().
                collect(Collectors.groupingBy(allocation->allocation.projectName,Collectors.summingInt(allocation->allocation.hoursAllocated)));
        System.out.println(ans1);

        //Employee(s) who worked the most total hours
        Map<String, Integer> empHours = allocations.stream().collect(Collectors.groupingBy(al->al.employeeName, Collectors.summingInt(al->al.hoursAllocated)));
        int maxHours = empHours.values().stream().max(Integer::compare).orElse(0);
        List<String> ans2 = empHours.entrySet().stream().filter(e->e.getValue()==maxHours).map(Map.Entry::getKey).toList();
        System.out.println(ans2);

        // Employees who worked >100 hours in a given month
        List<String> ans3 = allocations.stream().filter(al->al.month.equals("2025-05"))
                .collect(Collectors.groupingBy(al->al.employeeName,Collectors.summingInt(al->al.hoursAllocated)))
                        .entrySet().stream().filter(e->e.getValue()>=100)
                        .map(e->e.getKey()).toList();

        System.out.println(ans3);




    }
}
