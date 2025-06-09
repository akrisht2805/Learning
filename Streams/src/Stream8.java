import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Write a code to find the employee who is having third-largest salary who's name started with A.
 */
public class Stream8 {
    public static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " (₹" + salary + ")";
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 95000),
                new Employee(2, "Bob", "Engineering", 87000),
                new Employee(3, "Charlie", "HR", 67000),
                new Employee(4, "Akrisht", "HR", 72000),
                new Employee(5, "Eve", "Sales", 88000),
                new Employee(6, "Aric", "Engineering", 85000),
                new Employee(7, "Anil", "Engineering", 89000)
        );


        System.out.println(
                employees.stream()
                        .filter(employee -> employee.getName().startsWith("A"))
                        .sorted(Comparator.comparing((Employee emp) -> emp.getSalary()).reversed()) // or use Employee::getSalary
                        .skip(2)
                        .findFirst()
        );



    }
}
