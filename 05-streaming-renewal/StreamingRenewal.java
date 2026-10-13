/**
 * Week 8 · S8 · Problem 5 The Streaming Plan Renewal Reminder
 *
 * Basic lasts 30 days, Standard 90, Premium 365. Renewal is start date plus
 * that many days, using LocalDate so leap years are handled.
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingRenewal {
    interface Plan {
        String name();
        LocalDate renewalDate();
    }

    static final class Basic implements Plan {
        private final String name;
        private final LocalDate start;

        Basic(String name, LocalDate start) {
            this.name = name;
            this.start = start;
        }

        public String name() {
            return name;
        }

        public LocalDate renewalDate() {
            return start.plusDays(30);
        }
    }

    static final class Standard implements Plan {
        private final String name;
        private final LocalDate start;

        Standard(String name, LocalDate start) {
            this.name = name;
            this.start = start;
        }

        public String name() {
            return name;
        }

        public LocalDate renewalDate() {
            return start.plusDays(90);
        }
    }

    static final class Premium implements Plan {
        private final String name;
        private final LocalDate start;

        Premium(String name, LocalDate start) {
            this.name = name;
            this.start = start;
        }

        public String name() {
            return name;
        }

        public LocalDate renewalDate() {
            return start.plusDays(365);
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Plan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate start = LocalDate.parse(scanner.next());
            plans.add(switch (type) {
                case "BASIC" -> new Basic(name, start);
                case "STANDARD" -> new Standard(name, start);
                case "PREMIUM" -> new Premium(name, start);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        for (Plan plan : plans) {
            out.append(plan.name()).append(": ").append(plan.renewalDate()).append('\n');
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                4
                BASIC Asha 2024-01-15
                STANDARD Ravi 2024-02-01
                PREMIUM Neha 2024-03-10
                BASIC Kiran 2024-12-20
                """);
        System.out.print(output);
        if (!output.equals("""
                Asha: 2024-02-14
                Ravi: 2024-05-01
                Neha: 2025-03-10
                Kiran: 2025-01-19
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
