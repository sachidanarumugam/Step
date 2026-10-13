/**
 * Week 6 · S6 practice · M2 Hostel Mess Wallet Management
 *
 * balance is private. Outside code can top up, deduct, or read it — never assign it.
 */
public class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            this.balance = 0;
            System.out.println("Warning: negative opening balance reset to 0");
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        balance += amount;
        System.out.println("Balance after top-up: " + balance);
    }

    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
        if (wallet.getBalance() != 700.0) {
            throw new AssertionError("Balance changed on a rejected deduct");
        }
        System.out.println("Sample checks passed.");
    }
}
