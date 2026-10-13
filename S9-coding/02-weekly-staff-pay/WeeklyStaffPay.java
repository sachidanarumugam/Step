/**
 * Week 9 · S9 coding · Problem 2 Weekly Staff Pay
 *
 * Staff is abstract, so a person with no pay rule cannot be constructed.
 * Hourly pay is the rate for the first 40 hours and 1.5 times the rate after that.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WeeklyStaffPay {
    static abstract class Staff {
        final String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double pay();
    }

    static final class FullTime extends Staff {
        private final double weeklySalary;

        FullTime(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        double pay() {
            return weeklySalary;
        }
    }

    static final class Hourly extends Staff {
        private final double hours;
        private final double rate;

        Hourly(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double pay() {
            if (hours <= 40) {
                return hours * rate;
            }
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    static final class Intern extends Staff {
        private final double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double pay() {
            return stipend;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Staff> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            people.add(switch (type) {
                case "FULLTIME" -> new FullTime(name, scanner.nextDouble());
                case "HOURLY" -> new Hourly(name, scanner.nextDouble(), scanner.nextDouble());
                case "INTERN" -> new Intern(name, scanner.nextDouble());
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Staff person : people) {
            double pay = person.pay();
            total += pay;
            out.append(String.format(Locale.US, "%s: %.2f%n", person.name, pay));
        }
        out.append(String.format(Locale.US, "Total Payroll: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                FULLTIME Asha 12000
                HOURLY Ravi 45 200
                INTERN Neha 5000
                """);
        System.out.print(output);
        if (!output.equals("""
                Asha: 12000.00
                Ravi: 9500.00
                Neha: 5000.00
                Total Payroll: 26500.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
