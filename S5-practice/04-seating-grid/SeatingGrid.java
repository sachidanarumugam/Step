/**
 * Week 5 · S5 practice · Problem 4 Hackathon Seating Grid Optimizer
 *
 * rowAverage is the only place an average is computed. Rows may differ in length.
 * Below the threshold is a Quiet Zone; at or above it is a Buzzing Zone.
 */
public class SeatingGrid {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return row.length == 0 ? 0.0 : (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder report = new StringBuilder();
        for (int r = 0; r < seatingScores.length; r++) {
            double average = rowAverage(seatingScores[r]);
            String zone = average < threshold ? "Quiet Zone" : "Buzzing Zone";
            if (r > 0) {
                report.append(" | ");
            }
            report.append("Row ").append(r).append(": ").append(zone);
        }
        return report.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };
        String report = classifyRows(grid, 60);
        System.out.println(report);
        if (!report.equals("Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
