/**
 * Week 2 · S2 · Problem 4 — Masked Phone Number Formatter
 *
 * A valid number is exactly 10 digits. The display is XXXXXX- plus the last four.
 */
public class MaskedPhoneNumber {
    static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append(phone.substring(6));
        masked.insert(6, "-");
        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
        if (!maskPhoneNumber("9876543210").equals("XXXXXX-3210")
                || !maskPhoneNumber("98765").equals("Invalid phone number")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
