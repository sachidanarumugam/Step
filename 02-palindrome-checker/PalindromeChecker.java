/**
 * Week 1 · S1 · Problem 2 — Palindrome Checker (3 Approaches)
 *
 * The same text is checked three ways. All three must agree.
 */
public class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    static void report(String text) {
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean reversed = isPalindromeArrayReversal(text);
        if (iterative != recursive || recursive != reversed) {
            throw new AssertionError("Approaches disagree for " + text);
        }
        String label = iterative ? "Palindrome" : "Not Palindrome";
        System.out.printf("\"%s\"%nIterative: %s | Recursive: %s | Array Reversal: %s%n",
                text, label, label, label);
    }

    public static void main(String[] args) {
        report("madam");
        report("hello");
        System.out.println("Sample checks passed.");
    }
}
