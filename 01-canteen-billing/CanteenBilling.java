/**
 * Week 8 · S8 · Problem 1 The Canteen Billing Counter
 *
 * Student 10% off, staff 5% off, guest pays the bill plus a 10 service charge.
 * The billing loop calls finalAmount() and does not branch on customer type.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CanteenBilling {
    interface Customer {
        String type();
        double finalAmount();
    }

    static final class Student implements Customer {
        private final double bill;

        Student(double bill) {
            this.bill = bill;
        }

        public String type() {
            return "STUDENT";
        }

        public double finalAmount() {
            return bill * 0.90;
        }
    }

    static final class Staff implements Customer {
        private final double bill;

        Staff(double bill) {
            this.bill = bill;
        }

        public String type() {
            return "STAFF";
        }

        public double finalAmount() {
            return bill * 0.95;
        }
    }

    static final class Guest implements Customer {
        private final double bill;

        Guest(double bill) {
            this.bill = bill;
        }

        public String type() {
            return "GUEST";
        }

        public double finalAmount() {
            return bill + 10;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            bills.add(switch (type) {
                case "STUDENT" -> new Student(amount);
                case "STAFF" -> new Staff(amount);
                case "GUEST" -> new Guest(amount);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Customer customer : bills) {
            double due = customer.finalAmount();
            total += due;
            out.append(String.format(Locale.US, "%s: %.2f%n", customer.type(), due));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                STUDENT 200
                STAFF 300
                GUEST 150
                """);
        System.out.print(output);
        if (!output.equals("""
                STUDENT: 180.00
                STAFF: 285.00
                GUEST: 160.00
                Total: 625.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
