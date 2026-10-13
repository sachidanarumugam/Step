/**
 * Week 8 · S8 · Problem 3 The Hostel Electricity Bill
 *
 * Single: 8 per unit. Shared: 6 per unit split by occupants.
 * AC: 10 per unit plus 200. Occupant count is stored on the shared-room object
 * so the billing loop still treats every room the same way.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class HostelElectricity {
    interface Room {
        String type();
        double bill();
    }

    static final class SingleRoom implements Room {
        private final int units;

        SingleRoom(int units) {
            this.units = units;
        }

        public String type() {
            return "SINGLE";
        }

        public double bill() {
            return 8.0 * units;
        }
    }

    static final class SharedRoom implements Room {
        private final int units;
        private final int occupants;

        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }

        public String type() {
            return "SHARED";
        }

        public double bill() {
            return (6.0 * units) / occupants;
        }
    }

    static final class AcRoom implements Room {
        private final int units;

        AcRoom(int units) {
            this.units = units;
        }

        public String type() {
            return "AC";
        }

        public double bill() {
            return 10.0 * units + 200;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            rooms.add(switch (type) {
                case "SINGLE" -> new SingleRoom(units);
                case "SHARED" -> new SharedRoom(units, scanner.nextInt());
                case "AC" -> new AcRoom(units);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Room room : rooms) {
            double bill = room.bill();
            total += bill;
            out.append(String.format(Locale.US, "%s: %.2f%n", room.type(), bill));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                SINGLE 120
                SHARED 150 3
                AC 100
                """);
        System.out.print(output);
        if (!output.equals("""
                SINGLE: 960.00
                SHARED: 300.00
                AC: 1200.00
                Total: 2460.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
