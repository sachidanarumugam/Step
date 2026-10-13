/**
 * Week 5 · S5 assignment · Problem 4 Match Day Grid Analyzer
 *
 * rowAverage is called once per match. At or above the threshold is a Power Surge.
 * Rows may have different lengths.
 */
public class MatchDayGrid {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return row.length == 0 ? 0.0 : (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder report = new StringBuilder();
        for (int r = 0; r < runsPerOver.length; r++) {
            double average = rowAverage(runsPerOver[r]);
            String label = average >= threshold ? "Power Surge" : "Normal";
            if (r > 0) {
                report.append(" | ");
            }
            report.append("Match ").append(r).append(": ").append(label);
        }
        return report.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        String report = classifyMatches(grid, 8);
        System.out.println(report);
        if (!report.equals("Match 0: Normal | Match 1: Power Surge | Match 2: Normal")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
