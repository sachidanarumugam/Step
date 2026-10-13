/**
 * Week 4 · S4 practice · L5 Rotate Array
 *
 * k is reduced with modulo. Each value moves to index (i + k) % n.
 * Time O(n), space O(n).
 */
import java.util.Arrays;

public class RotateArray {
    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        k = k % n;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] a = rotateArray(new int[] {1, 2, 3, 4, 5, 6, 7}, 3);
        int[] b = rotateArray(new int[] {1, 2}, 3);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        if (!Arrays.equals(a, new int[] {5, 6, 7, 1, 2, 3, 4})
                || !Arrays.equals(b, new int[] {2, 1})) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
