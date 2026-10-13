/**
 * Week 4 · S4 assignment · A2 Maximum Subarray (Kadane)
 *
 * At each value, either extend the current run or restart at this value.
 * An all-negative array correctly returns the largest single value.
 * Time O(n), space O(1).
 *
 * Follow-up: divide and conquer splits the array, solves both halves, and also
 * checks the best subarray that crosses the midpoint (best suffix of the left
 * plus best prefix of the right). That version is O(n log n).
 */
public class MaximumSubarray {
    static int maxSubArray(int[] nums) {
        int best = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    public static void main(String[] args) {
        int a = maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int b = maxSubArray(new int[] {-3, -1, -2});
        System.out.println(a);
        System.out.println(b);
        if (a != 6 || b != -1) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
