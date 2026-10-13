/**
 * Week 9 · S9 assignment · Problem 1 Movie Ticket Counter
 *
 * Ticket is abstract, so a seat with no type cannot be sold. The convenience
 * fee of 20 is added in one final method shared by every seat type.
 * Regular 150, premium 250, recliner 400, each plus 20, times the count.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MovieTickets {
    static abstract class Ticket {
        static final double CONVENIENCE_FEE = 20;
        final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract String seat();

        abstract double pricePerTicket();

        final double amount() {
            return (pricePerTicket() + CONVENIENCE_FEE) * count;
        }
    }

    static final class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }

        String seat() {
            return "REGULAR";
        }

        double pricePerTicket() {
            return 150;
        }
    }

    static final class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }

        String seat() {
            return "PREMIUM";
        }

        double pricePerTicket() {
            return 250;
        }
    }

    static final class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }

        String seat() {
            return "RECLINER";
        }

        double pricePerTicket() {
            return 400;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Ticket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            bookings.add(switch (seat) {
                case "REGULAR" -> new Regular(count);
                case "PREMIUM" -> new Premium(count);
                case "RECLINER" -> new Recliner(count);
                default -> throw new IllegalArgumentException(seat);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Ticket ticket : bookings) {
            double amount = ticket.amount();
            total += amount;
            out.append(String.format(Locale.US, "%s: %.2f%n", ticket.seat(), amount));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                REGULAR 3
                PREMIUM 2
                RECLINER 1
                """);
        System.out.print(output);
        if (!output.equals("""
                REGULAR: 510.00
                PREMIUM: 540.00
                RECLINER: 420.00
                Total: 1470.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
