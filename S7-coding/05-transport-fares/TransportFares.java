/**
 * Week 7 · S7 coding · Problem 5 Public Transport Fare Calculator
 *
 * Bus fare is capped at 10. Metro multiplies the base fare by the peak-hour factor.
 * The total loop calls fare() and does not inspect the vehicle type.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TransportFares {
    interface Journey {
        String type();
        double fare();
    }

    static final class Bus implements Journey {
        private final double distance;

        Bus(double distance) {
            this.distance = distance;
        }

        public String type() {
            return "BUS";
        }

        public double fare() {
            return Math.min(10.0, 2 + 0.10 * distance);
        }
    }

    static final class Train implements Journey {
        private final double distance;

        Train(double distance) {
            this.distance = distance;
        }

        public String type() {
            return "TRAIN";
        }

        public double fare() {
            return 3 + 0.15 * distance;
        }
    }

    static final class Metro implements Journey {
        private final double distance;
        private final double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            this.distance = distance;
            this.peakHourFactor = peakHourFactor;
        }

        public String type() {
            return "METRO";
        }

        public double fare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            journeys.add(switch (type) {
                case "BUS" -> new Bus(distance);
                case "TRAIN" -> new Train(distance);
                case "METRO" -> new Metro(distance, scanner.nextDouble());
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Journey journey : journeys) {
            double fare = journey.fare();
            total += fare;
            out.append(String.format(Locale.US, "%s: %.2f%n", journey.type(), fare));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String sample = """
                3
                BUS 15
                TRAIN 50
                METRO 10 1.5
                """;
        String output = process(sample);
        System.out.print(output);
        String expected = """
                BUS: 3.50
                TRAIN: 10.50
                METRO: 5.25
                Total: 19.25
                """;
        if (!output.equals(expected)) {
            throw new AssertionError("Sample mismatch:\n" + output);
        }
        System.out.println("Sample checks passed.");
    }
}
