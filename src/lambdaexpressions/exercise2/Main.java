package lambdaexpressions.exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jan", "Kowalski"));
        employees.add(new Employee("Marzena", "Nowak"));
        employees.add(new Employee("Piotr", "Zielinski"));
        employees.add(new Employee("Katarzyna", "Wisniewska"));
        employees.add(new Employee("Tomasz", "Adamczyk"));

        System.out.println("Before sorting operation: ");
        for (Employee x : employees) {
            System.out.println(x);
        }

        Collections.sort(employees, (e1, e2) -> e1.getLastName().compareTo(e2.getLastName()));

        System.out.println("After sorting operation: ");
        for (Employee x : employees) {
            System.out.println(x);
        }
    }
}
