/**
 * Week 1 · S1 · Problem 5 — Reverse Customer Name
 *
 * Builds a new reversed string. The original argument is never modified
 * (Java strings are immutable; this method also never writes back into it).
 */
public class ReverseCustomerName {
    static String reverseCustomerName(String customerName) {
        char[] letters = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder(letters.length);
        for (int i = letters.length - 1; i >= 0; i--) {
            reversed.append(letters[i]);
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String original = "Sunil";
        String reversed = reverseCustomerName(original);
        System.out.println("Original Name: " + original);
        System.out.println("Reversed Name: " + reversed);
        if (!original.equals("Sunil") || !reversed.equals("linuS")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
