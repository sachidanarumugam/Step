/**
 * Week 10 · Part A · Problem 2 Word Reverser and Palindrome Checker
 *
 * The reverse is built with StringBuilder. Comparison is case-sensitive.
 */
public class WordReverser {
    static void reverseAndCheck(String word) {
        StringBuilder builder = new StringBuilder(word);
        String reversed = builder.reverse().toString();
        String label = word.equals(reversed) ? "palindrome" : "not a palindrome";
        System.out.println(reversed + " - " + label);
    }

    public static void main(String[] args) {
        reverseAndCheck("level");
        reverseAndCheck("java");
    }
}
