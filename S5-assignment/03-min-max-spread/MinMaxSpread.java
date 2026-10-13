/**
 * Week 5 · S5 assignment · Problem 3 Top Performer Tracker
 *
 * Minimum and maximum are found in one pass. Spread is max - min. No sort.
 */
public class MinMaxSpread {
    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        String report = findMinMaxSpread(new int[] {45, 82, 79, 90, 33, 90, 61});
        System.out.println(report);
        if (!report.equals("Min: 33 | Max: 90 | Spread: 57")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
