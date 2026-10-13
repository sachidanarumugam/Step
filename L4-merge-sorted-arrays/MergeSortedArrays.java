/**
 * Week 4 · S4 practice · L4 Merge Two Sorted Arrays
 *
 * Two pointers copy the smaller head into a new array, then drain the leftover side.
 * Time O(n + m), space O(n + m) for the result.
 */
import java.util.Arrays;

public class MergeSortedArrays {
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = mergeSortedArrays(new int[] {1, 3, 5}, new int[] {2, 4, 6});
        int[] b = mergeSortedArrays(new int[] {}, new int[] {1, 2, 3});
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        if (!Arrays.equals(a, new int[] {1, 2, 3, 4, 5, 6})
                || !Arrays.equals(b, new int[] {1, 2, 3})) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
