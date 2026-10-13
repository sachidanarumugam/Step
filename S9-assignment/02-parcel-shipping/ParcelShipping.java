/**
 * Week 9 · S9 assignment · Problem 2 Parcel Shipping Desk
 *
 * Every parcel can quote a shipping charge. Only express and fragile parcels
 * implement Insurable (2% of declared value). Standard insurance stays 0.
 * Fragile charge is the standard charge plus a handling fee of 50.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ParcelShipping {
    interface Insurable {
        double insurance();
    }

    static abstract class Parcel {
        final double weightKg;
        final double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        abstract String type();

        abstract double charge();

        double insurance() {
            return 0;
        }

        final double total() {
            return charge() + insurance();
        }
    }

    static final class StandardParcel extends Parcel {
        StandardParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        String type() {
            return "STANDARD";
        }

        double charge() {
            return 40 + 10 * weightKg;
        }
    }

    static final class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        String type() {
            return "EXPRESS";
        }

        double charge() {
            return 80 + 15 * weightKg;
        }

        @Override
        public double insurance() {
            return declaredValue * 0.02;
        }
    }

    static final class FragileParcel extends Parcel implements Insurable {
        FragileParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        String type() {
            return "FRAGILE";
        }

        double charge() {
            return 40 + 10 * weightKg + 50;
        }

        @Override
        public double insurance() {
            return declaredValue * 0.02;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();
            parcels.add(switch (type) {
                case "STANDARD" -> new StandardParcel(weight, value);
                case "EXPRESS" -> new ExpressParcel(weight, value);
                case "FRAGILE" -> new FragileParcel(weight, value);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double grand = 0;
        for (Parcel parcel : parcels) {
            grand += parcel.total();
            out.append(String.format(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), parcel.charge(), parcel.insurance(), parcel.total()));
        }
        out.append(String.format(Locale.US, "Grand Total: %.2f%n", grand));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                STANDARD 3 500
                EXPRESS 2 1000
                FRAGILE 4 2000
                """);
        System.out.print(output);
        if (!output.equals("""
                STANDARD: Charge=70.00 Insurance=0.00 Total=70.00
                EXPRESS: Charge=110.00 Insurance=20.00 Total=130.00
                FRAGILE: Charge=130.00 Insurance=40.00 Total=170.00
                Grand Total: 370.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
