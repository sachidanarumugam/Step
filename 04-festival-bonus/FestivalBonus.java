/**
 * Week 8 · S8 · Problem 4 The Festival Bonus Calculator
 *
 * Full-time 10%, part-time 5%, intern a flat 2000. Name and salary are shared
 * through the employee type; each subclass supplies its own bonus rule.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FestivalBonus {
    static abstract class Employee {
        final String name;
        final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double bonus();
    }

    static final class FullTime extends Employee {
        FullTime(String name, double salary) {
            super(name, salary);
        }

        double bonus() {
            return monthlySalary * 0.10;
        }
    }

    static final class PartTime extends Employee {
        PartTime(String name, double salary) {
            super(name, salary);
        }

        double bonus() {
            return monthlySalary * 0.05;
        }
    }

    static final class Intern extends Employee {
        Intern(String name, double salary) {
            super(name, salary);
        }

        double bonus() {
            return 2000;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Employee> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            staff.add(switch (type) {
                case "FULLTIME" -> new FullTime(name, salary);
                case "PARTTIME" -> new PartTime(name, salary);
                case "INTERN" -> new Intern(name, salary);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Employee employee : staff) {
            double bonus = employee.bonus();
            total += bonus;
            out.append(String.format(Locale.US, "%s: %.2f%n", employee.name, bonus));
        }
        out.append(String.format(Locale.US, "Total Bonus: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                FULLTIME Asha 50000
                PARTTIME Ravi 30000
                INTERN Neha 15000
                """);
        System.out.print(output);
        if (!output.equals("""
                Asha: 5000.00
                Ravi: 1500.00
                Neha: 2000.00
                Total Bonus: 8500.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
