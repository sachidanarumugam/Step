/**
 * Week 7 · S7 assignment · Problem 3 The Password Checker
 *
 * The password is private and final. Only a strength label is exposed.
 * Weak: under 6 characters. Medium: 6 to 9. Strong: 10 or more.
 */
public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        }
        if (length <= 9) {
            return "Medium";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        System.out.println(new PasswordChecker("abcd").getStrength());
        System.out.println(new PasswordChecker("abcdefgh").getStrength());
        System.out.println(new PasswordChecker("abcdefghij").getStrength());
        if (!new PasswordChecker("abcd").getStrength().equals("Weak")
                || !new PasswordChecker("abcdefgh").getStrength().equals("Medium")
                || !new PasswordChecker("abcdefghij").getStrength().equals("Strong")) {
            throw new AssertionError("Strength mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
