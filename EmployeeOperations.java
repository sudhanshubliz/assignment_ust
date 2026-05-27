import java.util.*;
import java.util.stream.*;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class EmployeeOperations {
    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
                new Employee(1, "Karthikeya", "IT", 150000, true),
                new Employee(2, "Sarma", "IT", 100000, true),
                new Employee(3, "Nagarjuna", "Non IT", 59000, true),
                new Employee(4, "Chiranjeevi", "Semi IT", 50000, true)
        );

        // Sort salaries descending
        List<Employee> res4 = emps.stream()
                .sorted(Comparator.comparingInt((Employee e) -> e.getSalary()).reversed())
                .collect(Collectors.toList());
        System.out.println("Salaries descending:");
        res4.forEach(System.out::println);

        // Count Active employees
        List<Employee> res5 = emps.stream()
                .filter(Employee::isActiveStatus)
                .collect(Collectors.toList());
        System.out.println("Active employees:");
        res5.forEach(System.out::println);

        // Group Employees by department
        Map<String, Long> res6 = emps.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
        System.out.println("Employees by department: " + res6);

        // Highest Salary Employee
        Optional<Employee> res7 = emps.stream()
                .max(Comparator.comparingInt((Employee e) -> e.getSalary()));

        if (res7.isPresent()) {
            System.out.println("Highest Salary Employee: " + res7.get());
        } else {
            System.out.println("No employees found.");
        }

        // Second Highest salary Employee
        Optional<Employee> res8 = emps.stream()
                .sorted(Comparator.comparingInt((Employee e) -> e.getSalary()).reversed())
                .skip(1)
                .findFirst();

        if (res8.isPresent()) {
            System.out.println("Second Highest Salary Employee: " + res8.get());
        } else {
            System.out.println("No employees found.");
        }
         // check Employees  with salary > 60000
        List<Employee> res1 = emps.stream()
                .filter(e -> e.getSalary() > 60000)
                .collect(Collectors.toList());
        System.out.println("Employees with salary > 60000:");
        res1.forEach(System.out::println);

        // Convert employee names to uppercase
        List<String> res2 = emps.stream()
                .map(e -> e.getName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Names uppercase:");
        res2.forEach(System.out::println);

        // Sort salaries ascending
        List<Employee> res3 = emps.stream()
                .sorted(Comparator.comparingInt(e -> e.getSalary()))
                .collect(Collectors.toList());
        System.out.println("Salaries ascending:");
        res3.forEach(System.out::println);
    }
}
