import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Employee> allEmployee = List.of(
            new Employee(1,"John", 25, 3000),
            new Employee(2,"Sam", 30, 4000),
            new Employee(3,"Alice", 35, 5000),
            new Employee(4,"Bob", 40, 6000),
            new Employee(5,"Rob", 50, 7000)
        );

        List<Employee> employees35 = allEmployee.stream()
                .filter(e -> e.age == 35)
                .collect(Collectors.toList());

        List<Employee> employees40 = allEmployee.stream()
                .filter(e -> e.age == 40)
                .collect(Collectors.toList());

        System.out.println("Employees aged 35:");
        employees35.forEach(System.out::println);

        System.out.println("\nEmployees aged 40:");
        employees40.forEach(System.out::println);

        List<Employee> employees35And40 = allEmployee.stream()
                .flatMap(employee -> {
                    if (employee.age == 35 || employee.age == 40) {
                        return Stream.of(employee);
                    } else {
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toList());

        System.out.println("Employees aged 35 or 40:");
        employees35And40.forEach(System.out::println);

        List<Employee> employees35And401 = allEmployee.stream()
                .filter(employee -> employee.age == 35 || employee.age == 40)
                .collect(Collectors.toList());

        System.out.println(employees35And401);
    }
}