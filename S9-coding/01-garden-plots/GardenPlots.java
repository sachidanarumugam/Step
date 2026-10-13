/**
 * Week 9 · S9 coding · Problem 1 Garden Plot Area Report
 *
 * Plot is abstract, so a shapeless plot cannot be created. A new shape is a new
 * subclass; the report loop only calls area().
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GardenPlots {
    static abstract class Plot {
        final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract String shape();

        abstract double area();
    }

    static final class CirclePlot extends Plot {
        private final double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        String shape() {
            return "CIRCLE";
        }

        double area() {
            return Math.PI * radius * radius;
        }
    }

    static final class RectanglePlot extends Plot {
        private final double length;
        private final double width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        String shape() {
            return "RECTANGLE";
        }

        double area() {
            return length * width;
        }
    }

    static final class TrianglePlot extends Plot {
        private final double base;
        private final double height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        String shape() {
            return "TRIANGLE";
        }

        double area() {
            return 0.5 * base * height;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            plots.add(switch (shape) {
                case "CIRCLE" -> new CirclePlot(owner, scanner.nextDouble());
                case "RECTANGLE" -> new RectanglePlot(owner, scanner.nextDouble(), scanner.nextDouble());
                case "TRIANGLE" -> new TrianglePlot(owner, scanner.nextDouble(), scanner.nextDouble());
                default -> throw new IllegalArgumentException(shape);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            total += area;
            out.append(String.format(Locale.US, "%s (%s): %.2f%n", plot.owner, plot.shape(), area));
        }
        out.append(String.format(Locale.US, "Total Area: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                CIRCLE Asha 5
                RECTANGLE Ravi 4 6
                TRIANGLE Neha 10 3
                """);
        System.out.print(output);
        if (!output.equals("""
                Asha (CIRCLE): 78.54
                Ravi (RECTANGLE): 24.00
                Neha (TRIANGLE): 15.00
                Total Area: 117.54
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
