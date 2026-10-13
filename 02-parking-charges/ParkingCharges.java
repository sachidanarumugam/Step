/**
 * Week 8 · S8 · Problem 2 The Campus Parking Charge Calculator
 *
 * Bike: 10 per hour. Car: 30 for the first hour plus 20 for each extra hour.
 * Truck: 50 per hour, minimum 100.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ParkingCharges {
    interface Vehicle {
        String type();
        double charge();
    }

    static final class Bike implements Vehicle {
        private final int hours;

        Bike(int hours) {
            this.hours = hours;
        }

        public String type() {
            return "BIKE";
        }

        public double charge() {
            return 10.0 * hours;
        }
    }

    static final class Car implements Vehicle {
        private final int hours;

        Car(int hours) {
            this.hours = hours;
        }

        public String type() {
            return "CAR";
        }

        public double charge() {
            return 30 + 20.0 * (hours - 1);
        }
    }

    static final class Truck implements Vehicle {
        private final int hours;

        Truck(int hours) {
            this.hours = hours;
        }

        public String type() {
            return "TRUCK";
        }

        public double charge() {
            return Math.max(100, 50.0 * hours);
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Vehicle> parked = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            parked.add(switch (type) {
                case "BIKE" -> new Bike(hours);
                case "CAR" -> new Car(hours);
                case "TRUCK" -> new Truck(hours);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Vehicle vehicle : parked) {
            double charge = vehicle.charge();
            total += charge;
            out.append(String.format(Locale.US, "%s: %.2f%n", vehicle.type(), charge));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                4
                BIKE 3
                CAR 4
                TRUCK 1
                CAR 1
                """);
        System.out.print(output);
        if (!output.equals("""
                BIKE: 30.00
                CAR: 90.00
                TRUCK: 100.00
                CAR: 30.00
                Total: 250.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
