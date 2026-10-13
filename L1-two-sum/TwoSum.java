/**
 * Week 4 · S4 practice · L1 Two Sum
 *
 * Nested loops check every pair of different positions. The input has one answer.
 * Time O(n^2), space O(1) besides the returned pair.
 */
import java.util.Arrays;

public class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] a = twoSum(new int[] {2, 7, 11, 15}, 9);
        int[] b = twoSum(new int[] {3, 2, 4}, 6);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        if (!Arrays.equals(a, new int[] {0, 1}) || !Arrays.equals(b, new int[] {1, 2})) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
