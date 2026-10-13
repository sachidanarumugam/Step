/**
 * Week 9 · S9 assignment · Problem 3 College Fee Counter
 *
 * Bus users implement CollegeBus. The transport fee of 12000 is declared once.
 * Hostellers do not implement it, so they pay no transport fee.
 * Day scholar 40000 + 12000. Hosteller 40000 + 60000. Scholar 20000 + 12000.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CollegeFees {
    interface CollegeBus {
        double TRANSPORT_FEE = 12000;

        default double transportFee() {
            return TRANSPORT_FEE;
        }
    }

    static abstract class CollegeStudent {
        final String name;

        CollegeStudent(String name) {
            this.name = name;
        }

        abstract double tuitionAndExtras();

        double totalFee() {
            double fee = tuitionAndExtras();
            if (this instanceof CollegeBus bus) {
                fee += bus.transportFee();
            }
            return fee;
        }
    }

    static final class DayScholar extends CollegeStudent implements CollegeBus {
        DayScholar(String name) {
            super(name);
        }

        double tuitionAndExtras() {
            return 40000;
        }
    }

    static final class Hosteller extends CollegeStudent {
        Hosteller(String name) {
            super(name);
        }

        double tuitionAndExtras() {
            return 40000 + 60000;
        }
    }

    static final class Scholar extends CollegeStudent implements CollegeBus {
        Scholar(String name) {
            super(name);
        }

        double tuitionAndExtras() {
            return 20000;
        }
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<CollegeStudent> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            students.add(switch (type) {
                case "DAY_SCHOLAR" -> new DayScholar(name);
                case "HOSTELLER" -> new Hosteller(name);
                case "SCHOLAR" -> new Scholar(name);
                default -> throw new IllegalArgumentException(type);
            });
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (CollegeStudent student : students) {
            double fee = student.totalFee();
            total += fee;
            out.append(String.format(Locale.US, "%s: %.2f%n", student.name, fee));
        }
        out.append(String.format(Locale.US, "Total Collected: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String output = process("""
                3
                DAY_SCHOLAR Asha
                HOSTELLER Ravi
                SCHOLAR Neha
                """);
        System.out.print(output);
        if (!output.equals("""
                Asha: 52000.00
                Ravi: 100000.00
                Neha: 32000.00
                Total Collected: 184000.00
                """)) {
            throw new AssertionError(output);
        }
        System.out.println("Sample checks passed.");
    }
}
