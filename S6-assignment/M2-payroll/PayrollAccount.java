/**
 * Week 6 · S6 assignment · M2 Payroll Salary Management
 *
 * basicSalary and bonus are private. Tax is a percentage of basic salary.
 * Net salary is basic + bonus and has no setter.
 */
public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasic) {
        if (openingBasic < 0) {
            this.basicSalary = 0;
            System.out.println("Warning: negative basic salary reset to 0");
        } else {
            this.basicSalary = openingBasic;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be positive");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percent must be between 0 and 100");
            return;
        }
        basicSalary = basicSalary - (basicSalary * percent / 100.0);
        System.out.println("Tax deducted: " + (percent == (long) percent ? String.format("%.0f", percent) : percent) + "%");
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
        if (account.getNetSalary() != 50000.0) {
            throw new AssertionError("Net salary mismatch: " + account.getNetSalary());
        }
        System.out.println("Sample checks passed.");
    }
}
