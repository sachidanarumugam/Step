/**
 * Week 7 · S7 coding · Problem 1 Payment System Fee Calculation
 *
 * Each payment type implements adjustedAmount(). The processor loop never
 * branches on the payment name; it only calls the shared method.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PaymentFees {
    interface Payment {
        String type();
        double adjustedAmount();
    }

    static final class CardPayment implements Payment {
        private final double amount;

        CardPayment(double amount) {
            this.amount = amount;
        }

        public String type() {
            return "CARD";
        }

        public double adjustedAmount() {
            return amount * 1.02;
        }
    }

    static final class WalletPayment implements Payment {
        private final double amount;

        WalletPayment(double amount) {
            this.amount = amount;
        }

        public String type() {
            return "WALLET";
        }

        public double adjustedAmount() {
            return amount * 1.01;
        }
    }

    static final class BankTransferPayment implements Payment {
        private final double amount;

        BankTransferPayment(double amount) {
            this.amount = amount;
        }

        public String type() {
            return "BANKTRANSFER";
        }

        public double adjustedAmount() {
            return amount;
        }
    }

    static Payment create(String type, double amount) {
        return switch (type) {
            case "CARD" -> new CardPayment(amount);
            case "WALLET" -> new WalletPayment(amount);
            case "BANKTRANSFER" -> new BankTransferPayment(amount);
            default -> throw new IllegalArgumentException(type);
        };
    }

    static String process(String input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            payments.add(create(scanner.next(), scanner.nextDouble()));
        }
        scanner.close();
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Payment payment : payments) {
            double adjusted = payment.adjustedAmount();
            total += adjusted;
            out.append(String.format(Locale.US, "%s: %.2f%n", payment.type(), adjusted));
        }
        out.append(String.format(Locale.US, "Total: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String sample = """
                3
                CARD 1000
                WALLET 500
                BANKTRANSFER 2000
                """;
        String output = process(sample);
        System.out.print(output);
        String expected = """
                CARD: 1020.00
                WALLET: 505.00
                BANKTRANSFER: 2000.00
                Total: 3525.00
                """;
        if (!output.equals(expected)) {
            throw new AssertionError("Sample mismatch:\n" + output);
        }
        System.out.println("Sample checks passed.");
    }
}
