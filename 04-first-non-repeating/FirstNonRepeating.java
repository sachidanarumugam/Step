/**
 * Week 1 · S1 · Problem 4 — First Non-Repeating Character
 *
 * Counts frequency, then scans left to right for the first character seen once.
 * Returns 0 when every character repeats.
 */
public class FirstNonRepeating {
    static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[Character.MAX_VALUE + 1];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return 0;
    }

    static void report(String text) {
        char found = findFirstNonRepeatingChar(text);
        if (found == 0) {
            System.out.println("\"" + text + "\"");
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("\"" + text + "\"");
            System.out.println("First Non-Repeating Character: '" + found + "'");
        }
    }

    public static void main(String[] args) {
        report("swiss");
        report("aabbcc");
        if (findFirstNonRepeatingChar("swiss") != 'w' || findFirstNonRepeatingChar("aabbcc") != 0) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
