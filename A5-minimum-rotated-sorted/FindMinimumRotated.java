/**
 * Week 4 · S4 assignment · A5 Find Minimum in Rotated Sorted Array
 *
 * Modified binary search. If the middle value is greater than the right end,
 * the minimum sits in the right half. Otherwise it sits in the left half,
 * including the middle. Already-sorted input returns the first element.
 * Time O(log n), space O(1). A linear scan would be correct but too slow for full marks.
 */
public class FindMinimumRotated {
    static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int a = findMin(new int[] {3, 4, 5, 1, 2});
        int b = findMin(new int[] {4, 5, 6, 7, 0, 1, 2});
        int c = findMin(new int[] {11, 13, 15, 17});
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        if (a != 1 || b != 0 || c != 11) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
