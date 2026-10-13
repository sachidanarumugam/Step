/**
 * Week 10 · coding assignment · Problem 7 Second-Best Score
 *
 * One pass keeps the highest and second-highest distinct scores.
 * A score equal to the current highest is skipped. The array is not sorted.
 * Time O(n), space O(1). Sorting first would be O(n log n) time and would
 * still need a second scan to skip duplicates of the maximum.
 */
public class SecondBestScore {
    static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }

    public static void main(String[] args) {
        int a = secondHighest(new int[] {45, 78, 92, 78, 60});
        int b = secondHighest(new int[] {50, 50, 50});
        System.out.println(a);
        System.out.println(b);
        if (a != 78 || b != -1) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
