/**
 * Week 4 · S4 assignment · A4 Subarray Sum Equals K
 *
 * prefix[j] - prefix[i] = k means an earlier prefix equalled currentSum - k.
 * A hash map counts how many times each prefix sum has been seen.
 * The empty prefix 0 is stored once so a subarray starting at index 0 is counted.
 *
 * A sliding window is the wrong tool here: negative numbers mean growing the
 * window can decrease the sum, so you cannot decide which side to shrink.
 * Time O(n), space O(n).
 */
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);
        int current = 0;
        int count = 0;
        for (int value : nums) {
            current += value;
            count += seen.getOrDefault(current - k, 0);
            seen.put(current, seen.getOrDefault(current, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a = subarraySum(new int[] {1, 1, 1}, 2);
        int b = subarraySum(new int[] {1, -1, 0}, 0);
        System.out.println(a);
        System.out.println(b);
        if (a != 2 || b != 3) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
