/**
 * Week 10 · coding assignment · Problem 10 Busiest Bus Row
 *
 * Outer loop walks rows, inner loop sums seats. A tie keeps the smaller index
 * because the best total is replaced only when the new total is strictly larger.
 * Time O(r * c), extra space O(1).
 */
public class BusiestBusRow {
    static String busiestRow(int[][] grid) {
        int bestIndex = 0;
        int bestTotal = Integer.MIN_VALUE;
        for (int r = 0; r < grid.length; r++) {
            int total = 0;
            for (int seat : grid[r]) {
                total += seat;
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestIndex = r;
            }
        }
        return "Row " + bestIndex + ", Total " + bestTotal;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };
        String result = busiestRow(grid);
        System.out.println(result);
        System.out.println("Time O(r * c), additional space O(1).");
        if (!result.equals("Row 1, Total 7")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
