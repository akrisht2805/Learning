import java.util.Arrays;
import java.util.List;

/**
 * Write a Java program using Streams to:
 * Filter out employees who are younger than 30.
 * Increase the salary of the remaining employees by 10%.
 * Collect the updated employees into a new list.
 * Print the final list.
 * */

public class Stream9 {

    public static record Employee(String name,int age,double salary){}

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 28, 50000),
                new Employee("Bob", 35, 60000),
                new Employee("Charlie", 32, 55000),
                new Employee("Diana", 25, 48000),
                new Employee("Ethan", 40, 70000),
                new Employee("Fiona", 30, 52000)
        );

        System.out.println(
                employees.stream()
                        .filter(emp->emp.age<=30)
                        .map(emp-> new Employee( emp.name,emp.age,emp.salary+((emp.salary*10)/100)))
                        .toList()

                );

    }
}
