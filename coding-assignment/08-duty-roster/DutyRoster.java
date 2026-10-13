/**
 * Week 10 · coding assignment · Problem 8 Duty Roster Rotation
 *
 * Right rotation by k. k % n drops complete turns, which matters when k is up to 1e9.
 * Name at index i moves to (i + k) % n.
 * Time O(n), space O(n).
 *
 * Rotating one place at a time, k times, is O(n * k). With k = 1e9 that is far too slow
 * even though the visible result repeats every n places.
 */
import java.util.Arrays;

public class DutyRoster {
    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];
        int shift = (int) ((k % n + n) % n);
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        String[] a = rotateRoster(names, 2);
        String[] b = rotateRoster(names, 7);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        if (!Arrays.equals(a, new String[] {"D", "E", "A", "B", "C"})
                || !Arrays.equals(b, new String[] {"D", "E", "A", "B", "C"})) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
