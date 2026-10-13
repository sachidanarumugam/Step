/**
 * Week 4 · S4 assignment · A1 Product of Array Except Self
 *
 * Forward pass stores the product of everything to the left.
 * Backward pass multiplies the product of everything to the right.
 * Division is never used, so a zero does not break the calculation.
 * Time O(n), extra space O(1) beyond the output array.
 */
import java.util.Arrays;

public class ProductExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = productExceptSelf(new int[] {1, 2, 3, 4});
        int[] b = productExceptSelf(new int[] {-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        if (!Arrays.equals(a, new int[] {24, 12, 8, 6})
                || !Arrays.equals(b, new int[] {0, 0, 9, 0, 0})) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
