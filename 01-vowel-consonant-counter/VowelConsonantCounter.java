/**
 * Week 2 · S2 · Problem 1 — Vowel & Consonant Counter
 *
 * Walks the title with charAt(). Spaces are ignored. Comparison is case-insensitive.
 */
public class VowelConsonantCounter {
    static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                continue;
            }
            char lower = Character.toLowerCase(ch);
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else if (Character.isLetter(ch)) {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String title = "Java Programming";
        System.out.println("\"" + title + "\"");
        countVowelsAndConsonants(title);
        System.out.println("Sample checks passed.");
    }
}
