/**
 * Week 9 · S9 coding · Problem 3 Library Late Fine Counter
 *
 * Books: 2 per day. DVDs: 5 per day, capped at 50. Magazines: 1 per day.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LibraryFines {
    static abstract class LibraryItem {
        final String title;
        final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();
    }

    static final class Book extends LibraryItem {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return 2.0 * daysLate;
        }
    }

    static final class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return Math.min(50, 5.0 * daysLate);
        }
    }

    static final class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return 1.0 * daysLate;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int days = scanner.nextInt();
            items.add(switch (type) {
                case "BOOK" -> new Book(title, days);
                case "DVD" -> new Dvd(title, days);
                case "MAGAZINE" -> new Magazine(title, days);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.fine();
            total += fine;
            out.append(String.format(Locale.US, "%s: %.2f%n", item.title, fine));
        }
        out.append(String.format(Locale.US, "Total Fines: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                BOOK Algebra 4
                DVD Inception 12
                MAGAZINE Sports 3
                """);
        System.out.print(output);
        if (!output.equals("""
                Algebra: 8.00
                Inception: 50.00
                Sports: 3.00
                Total Fines: 61.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
