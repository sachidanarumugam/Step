/**
 * Week 9 · S9 coding · Problem 4 Electricity Connection Billing
 *
 * Home: 5 for the first 100 units, 7 after that.
 * Shop: 8 per unit plus 100. Factory: 6 per unit, minimum bill 1000.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ElectricityBilling {
    static abstract class Connection {
        final int units;

        Connection(int units) {
            this.units = units;
        }

        abstract String type();

        abstract double bill();
    }

    static final class Home extends Connection {
        Home(int units) {
            super(units);
        }

        String type() {
            return "HOME";
        }

        double bill() {
            if (units <= 100) {
                return 5.0 * units;
            }
            return 5.0 * 100 + 7.0 * (units - 100);
        }
    }

    static final class Shop extends Connection {
        Shop(int units) {
            super(units);
        }

        String type() {
            return "SHOP";
        }

        double bill() {
            return 8.0 * units + 100;
        }
    }

    static final class Factory extends Connection {
        Factory(int units) {
            super(units);
        }

        String type() {
            return "FACTORY";
        }

        double bill() {
            return Math.max(1000, 6.0 * units);
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            connections.add(switch (type) {
                case "HOME" -> new Home(units);
                case "SHOP" -> new Shop(units);
                case "FACTORY" -> new Factory(units);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Connection connection : connections) {
            double bill = connection.bill();
            total += bill;
            out.append(String.format(Locale.US, "%s: %.2f%n", connection.type(), bill));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                HOME 150
                SHOP 90
                FACTORY 120
                """);
        System.out.print(output);
        if (!output.equals("""
                HOME: 850.00
                SHOP: 820.00
                FACTORY: 1000.00
                Total: 2670.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
