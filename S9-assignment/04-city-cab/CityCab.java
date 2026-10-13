/**
 * Week 9 · S9 assignment · Problem 4 City Cab Fare Meter
 *
 * The minimum fare of 100 is applied once, in the shared cab type.
 * Night service is an ability only sedan and SUV implement. A night mini is rejected.
 * Night adds 20% after the minimum is applied.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CityCab {
    interface NightService {
        default double applyNight(double fare) {
            return fare * 1.20;
        }
    }

    static abstract class Cab {
        abstract String type();

        abstract double rate();

        Double quote(double km, boolean night) {
            if (night && !(this instanceof NightService)) {
                return null;
            }
            double fare = Math.max(100, km * rate());
            if (night) {
                fare = ((NightService) this).applyNight(fare);
            }
            return fare;
        }
    }

    static final class Mini extends Cab {
        String type() {
            return "MINI";
        }

        double rate() {
            return 10;
        }
    }

    static final class Sedan extends Cab implements NightService {
        String type() {
            return "SEDAN";
        }

        double rate() {
            return 14;
        }
    }

    static final class Suv extends Cab implements NightService {
        String type() {
            return "SUV";
        }

        double rate() {
            return 18;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        record Trip(Cab cab, double km, boolean night) {
        }
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double km = scanner.nextDouble();
            boolean night = scanner.next().equals("NIGHT");
            Cab cab = switch (type) {
                case "MINI" -> new Mini();
                case "SEDAN" -> new Sedan();
                case "SUV" -> new Suv();
                default -> throw new IllegalArgumentException(type);
            };
            trips.add(new Trip(cab, km, night));
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Trip trip : trips) {
            Double fare = trip.cab.quote(trip.km, trip.night);
            if (fare == null) {
                out.append(trip.cab.type()).append(": night service not available\n");
            } else {
                total += fare;
                out.append(String.format(Locale.US, "%s: %.2f%n", trip.cab.type(), fare));
            }
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                4
                MINI 8 DAY
                SEDAN 10 NIGHT
                SUV 20 DAY
                MINI 5 NIGHT
                """);
        System.out.print(output);
        if (!output.equals("""
                MINI: 100.00
                SEDAN: 168.00
                SUV: 360.00
                MINI: night service not available
                Total: 628.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
