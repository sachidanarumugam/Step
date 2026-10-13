/**
 * Week 10 · coding assignment · Problem 6 Class Attendance Tracker
 *
 * One pass counts present days and the longest run of 1s.
 * The running streak grows on 1 and resets on 0.
 * Time O(n), space O(1). Both answers are found in that single pass.
 */
public class AttendanceTracker {
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longest = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;
                if (streak > longest) {
                    longest = streak;
                }
            } else {
                streak = 0;
            }
        }
        return new int[] {present, longest};
    }

    public static void main(String[] args) {
        int[] a = attendanceSummary(new int[] {1, 1, 0, 1, 1, 1, 0, 1});
        int[] b = attendanceSummary(new int[] {0, 0, 0});
        System.out.println("Present: " + a[0] + ", Longest streak: " + a[1]);
        System.out.println("Present: " + b[0] + ", Longest streak: " + b[1]);
        System.out.println("Time O(n), space O(1). Yes, both answers come from one pass.");
        if (a[0] != 6 || a[1] != 3 || b[0] != 0 || b[1] != 0) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
