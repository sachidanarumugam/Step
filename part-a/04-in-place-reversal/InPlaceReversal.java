/**
 * Week 10 · Part A · Problem 4 In-Place Array Reversal
 *
 * Two pointers swap toward the middle. No second list is allocated.
 */
import java.util.Arrays;

public class InPlaceReversal {
    static void reverse(int[] tokens) {
        int left = 0;
        int right = tokens.length - 1;
        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] tokens = {11, 22, 33, 44};
        reverse(tokens);
        System.out.println(Arrays.toString(tokens));
        if (!Arrays.equals(tokens, new int[] {44, 33, 22, 11})) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
