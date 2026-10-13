/**
 * Week 5 · S5 practice · Problem 3 Top-3 Podium Finder
 *
 * One pass. Ties are kept: a second 90 shifts the previous 90 into second place.
 * The array is never sorted.
 */
import java.util.Arrays;

public class TopThreeScores {
    static int[] findTopThreeScores(int[] scores) {
        int first = scores[0];
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean seenSecond = false;
        for (int i = 1; i < scores.length; i++) {
            int score = scores[i];
            if (score >= first) {
                third = second;
                second = first;
                seenSecond = true;
                first = score;
            } else if (!seenSecond || score >= second) {
                third = second;
                second = score;
                seenSecond = true;
            } else if (score >= third) {
                third = score;
            }
        }
        return new int[] {first, second, third};
    }

    public static void main(String[] args) {
        int[] top = findTopThreeScores(new int[] {45, 82, 79, 90, 33, 90, 61});
        System.out.println(Arrays.toString(top));
        if (!Arrays.equals(top, new int[] {90, 90, 82})) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
