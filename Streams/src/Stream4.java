import java.util.*;
import java.util.stream.Collectors;

/**You have a list of employee records, each containing id, name, department, and salary. Using Java Streams:
 * Group employees by department.
 * Then, within each department, find the employee with the highest salary.
 * */

public class Stream4 {

    public static class Employee {
        private int id;
        private String name;
        private String department;
        private int salary;

        public Employee(int id, String name, String department, int salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

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
                new Employee(4, "David", "HR", 72000),
                new Employee(5, "Eve", "Sales", 88000)
        );

        Map<String, Optional<Employee>> res = employees.stream().
                collect(Collectors.groupingBy(employee -> employee.department, Collectors.maxBy(Comparator.comparingInt(emp->emp.salary)) ));

        res.forEach((key,value)->{
            System.out.println(key+" -> "+value);
        });

    }
}
