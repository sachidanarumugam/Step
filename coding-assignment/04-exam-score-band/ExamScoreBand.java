/**
 * Week 10 · coding assignment · Problem 4 Exam Score Band Counter
 *
 * scores is sorted. A linear scan is O(n) time. This answer is two binary searches:
 * the first index with score >= low, and the first index with score > high.
 * The count is the difference, so duplicates on both edges are included.
 * Time O(log n), space O(1).
 *
 * A plain binary search that stops at any match would miss repeated scores
 * sitting to the left of low or to the right of high.
 */
public class ExamScoreBand {
    static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        int a = countInBand(scores, 42, 58);
        int b = countInBand(scores, 90, 100);
        System.out.println(a);
        System.out.println(b);
        System.out.println("Time O(log n), space O(1). A linear scan is O(n) time and O(1) space.");
        System.out.println("Rotating or scanning one score at a time cannot use the sorted order.");
        if (a != 6 || b != 0) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
