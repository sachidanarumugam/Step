/**
 * Week 10 · Part A · Problem 1 Vowel and Consonant Counter
 */
public class VowelConsonantCounter {
    static void count(String word) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (Character.isLetter(ch)) {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        count("Programming");
        if (!"Programming".toLowerCase().contains("o")) {
            throw new AssertionError("unexpected");
        }
    }
}
