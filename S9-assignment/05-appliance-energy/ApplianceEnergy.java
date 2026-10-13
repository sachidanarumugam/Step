/**
 * Week 9 · S9 assignment · Problem 5 Home Appliance Energy Report
 *
 * Units = watts * hours / 1000. Cost = units * 8.
 * Saver mode cuts units by 25% and is an interface only AC and the washer implement.
 * Asking a fridge or TV for saver mode is reported instead of priced.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ApplianceEnergy {
    interface SaverMode {
        default double applySaver(double units) {
            return units * 0.75;
        }
    }

    static abstract class Appliance {
        abstract String name();

        abstract double watts();

        Double units(double hours, boolean saver) {
            if (saver && !(this instanceof SaverMode)) {
                return null;
            }
            double units = watts() * hours / 1000.0;
            if (saver) {
                units = ((SaverMode) this).applySaver(units);
            }
            return units;
        }

        static final double RATE = 8;
    }

    static final class Fridge extends Appliance {
        String name() {
            return "FRIDGE";
        }

        double watts() {
            return 150;
        }
    }

    static final class AirConditioner extends Appliance implements SaverMode {
        String name() {
            return "AC";
        }

        double watts() {
            return 1500;
        }
    }

    static final class Television extends Appliance {
        String name() {
            return "TV";
        }

        double watts() {
            return 100;
        }
    }

    static final class Washer extends Appliance implements SaverMode {
        String name() {
            return "WASHER";
        }

        double watts() {
            return 500;
        }
    }

    static String process(String input) {
        String[] lines = input.strip().split("\\R");
        int n = Integer.parseInt(lines[0].trim());
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (int i = 1; i <= n; i++) {
            String[] parts = lines[i].trim().split(" ");
            Appliance appliance = switch (parts[0]) {
                case "FRIDGE" -> new Fridge();
                case "AC" -> new AirConditioner();
                case "TV" -> new Television();
                case "WASHER" -> new Washer();
                default -> throw new IllegalArgumentException(parts[0]);
            };
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            Double units = appliance.units(hours, saver);
            if (units == null) {
                out.append(appliance.name()).append(": saver mode not supported\n");
            } else {
                double cost = units * Appliance.RATE;
                total += cost;
                out.append(String.format(Locale.US, "%s: Units=%.2f Cost=%.2f%n",
                        appliance.name(), units, cost));
            }
        }
        out.append(String.format(Locale.US, "Total Cost: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                4
                FRIDGE 24
                AC 8 SAVER
                TV 5
                WASHER 2 SAVER
                """);
        System.out.print(output);
        if (!output.equals("""
                FRIDGE: Units=3.60 Cost=28.80
                AC: Units=9.00 Cost=72.00
                TV: Units=0.50 Cost=4.00
                WASHER: Units=0.75 Cost=6.00
                Total Cost: 110.80
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
