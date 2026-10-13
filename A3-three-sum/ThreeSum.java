/**
 * Week 4 · S4 assignment · A3 3Sum
 *
 * Sort, then for each index use two pointers on the remainder.
 * Duplicate values are skipped at the fixed index and at both pointers.
 * Time O(n^2), space O(1) besides the answer list (sort may use O(log n)).
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> trips = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    trips.add(new int[] {nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return trips.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a = threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        int[][] b = threeSum(new int[] {0, 0, 0});
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));
        if (a.length != 2 || b.length != 1 || !Arrays.equals(b[0], new int[] {0, 0, 0})) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
