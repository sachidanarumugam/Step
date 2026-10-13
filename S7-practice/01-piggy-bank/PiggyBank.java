/**
 * Week 7 · S7 practice · Problem 1 The Piggy Bank
 *
 * savings is private and starts at 0. id is final. There is no setter.
 */
public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("withdraw(" + amount + ") -> rejected, savings stays " + savings);
            return;
        }
        savings -= amount;
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("deposit(100) -> savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("withdraw(30) -> savings = " + pb.getSavings());
        pb.withdraw(500);
        if (pb.getSavings() != 70 || !pb.getId().equals("PB-1")) {
            throw new AssertionError("Piggy bank rules failed");
        }
        System.out.println("Sample checks passed.");
    }
}
