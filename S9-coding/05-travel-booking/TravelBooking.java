/**
 * Week 9 · S9 coding · Problem 5 Travel Booking with a Common Fee
 *
 * BOOKING_FEE lives in one place on the abstract booking. Each mode only
 * supplies its base fare. The sample does not ask for a grand total.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TravelBooking {
    static abstract class Booking {
        static final double BOOKING_FEE = 50;
        final double distanceKm;

        Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract String mode();

        abstract double baseFare();

        final double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static final class BusBooking extends Booking {
        BusBooking(double km) {
            super(km);
        }

        String mode() {
            return "BUS";
        }

        double baseFare() {
            return 2 * distanceKm;
        }
    }

    static final class TrainBooking extends Booking {
        TrainBooking(double km) {
            super(km);
        }

        String mode() {
            return "TRAIN";
        }

        double baseFare() {
            return 1.5 * distanceKm;
        }
    }

    static final class FlightBooking extends Booking {
        FlightBooking(double km) {
            super(km);
        }

        String mode() {
            return "FLIGHT";
        }

        double baseFare() {
            return 2500 + 4 * distanceKm;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double km = scanner.nextDouble();
            bookings.add(switch (mode) {
                case "BUS" -> new BusBooking(km);
                case "TRAIN" -> new TrainBooking(km);
                case "FLIGHT" -> new FlightBooking(km);
                default -> throw new IllegalArgumentException(mode);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        for (Booking booking : bookings) {
            out.append(String.format(Locale.US, "%s: %.2f%n", booking.mode(), booking.total()));
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                BUS 200
                TRAIN 300
                FLIGHT 500
                """);
        System.out.print(output);
        if (!output.equals("""
                BUS: 450.00
                TRAIN: 500.00
                FLIGHT: 4550.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
