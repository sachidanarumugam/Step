/**
 * Week 7 · S7 coding · Problem 3 Delivery Fee Calculator
 *
 * Fees follow the written business rules:
 *   Standard:      5 + 0.50*kg + 0.10*km
 *   Express:       15 + 1.00*kg + 0.20*km
 *   International: 25 + 2.00*kg + 0.50*km + customs
 *
 * The printed sample lists EXPRESS 29.00 and INTERNATIONAL 155.00.
 * Those two figures do not match the rates above (they come out to 24.00 and 145.00).
 * This solution follows the business rules. The processing loop only calls fee().
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DeliveryFees {
    interface Delivery {
        String type();
        double fee();
    }

    static final class StandardDelivery implements Delivery {
        private final double weight;
        private final double distance;

        StandardDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public String type() {
            return "STANDARD";
        }

        public double fee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static final class ExpressDelivery implements Delivery {
        private final double weight;
        private final double distance;

        ExpressDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public String type() {
            return "EXPRESS";
        }

        public double fee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static final class InternationalDelivery implements Delivery {
        private final double weight;
        private final double distance;
        private final double customsFee;

        InternationalDelivery(double weight, double distance, double customsFee) {
            this.weight = weight;
            this.distance = distance;
            this.customsFee = customsFee;
        }

        public String type() {
            return "INTERNATIONAL";
        }

        public double fee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            deliveries.add(switch (type) {
                case "STANDARD" -> new StandardDelivery(weight, distance);
                case "EXPRESS" -> new ExpressDelivery(weight, distance);
                case "INTERNATIONAL" -> new InternationalDelivery(weight, distance, scanner.nextDouble());
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.fee();
            total += fee;
            out.append(String.format(Locale.US, "%s: %.2f%n", delivery.type(), fee));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String sample = """
                3
                STANDARD 10 50
                EXPRESS 5 20
                INTERNATIONAL 20 100 30
                """;
        String output = process(sample);
        System.out.print(output);
        String expected = """
                STANDARD: 15.00
                EXPRESS: 24.00
                INTERNATIONAL: 145.00
                Total: 184.00
                """;
        if (!output.equals(expected)) {
            throw new AssertionError("Rule check failed:\n" + output);
        }
        System.out.println("Business-rule checks passed.");
        System.out.println("Note: the sheet's printed sample (29.00 / 155.00 / 199.00) does not follow the stated rates.");
    }
}
