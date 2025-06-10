import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Write a code to find the employee who is having third-largest salary who's name started with A.
 */
public class Stream8 {

    public static record Employee (int id,String name, String department, Double salary){}

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 95000.0),
                new Employee(2, "Bob", "Engineering", 87000.0),
                new Employee(3, "Charlie", "HR", 67000.0),
                new Employee(4, "Akrisht", "HR", 72000.0),
                new Employee(5, "Eve", "Sales", 88000.0),
                new Employee(6, "Aric", "Engineering", 85000.0),
                new Employee(7, "Anil", "Engineering", 89000.0)
        );


        System.out.println(
                employees.stream()
                        .filter(employee -> employee.name().startsWith("A"))
                        .sorted(Comparator.comparing((Employee emp) -> emp.salary()).reversed()) // or use Employee::getSalary
                        .skip(2)
                        .findFirst()
        );



    }
}
