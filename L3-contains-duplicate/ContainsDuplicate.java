/**
 * Week 4 · S4 practice · L3 Contains Duplicate
 *
 * Pairwise comparison with nested loops. No collections. Stops at the first match.
 * Time O(n^2), space O(1).
 */
public class ContainsDuplicate {
    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean a = containsDuplicate(new int[] {1, 2, 3, 1});
        boolean b = containsDuplicate(new int[] {1, 2, 3, 4});
        System.out.println(a);
        System.out.println(b);
        if (!a || b) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
