import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**How to calculate average salary per department using Stream API?
 * */
public class Stream5 {


    public static void main(String[] args) {

        List<Stream4.Employee> employees = Arrays.asList(
                new Stream4.Employee(1, "Alice", "Engineering", 95000),
                new Stream4.Employee(2, "Bob", "Engineering", 87000),
                new Stream4.Employee(3, "Charlie", "HR", 67000),
                new Stream4.Employee(4, "David", "HR", 72000),
                new Stream4.Employee(5, "Eve", "Sales", 88000)
        );

        Map<String, Double> avgDepartmentWise = employees.stream().
                collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.averagingDouble(emp->emp.getSalary())));

        avgDepartmentWise.forEach((key,value)->{
            System.out.println(key+" = "+value);
        });


    }
}
