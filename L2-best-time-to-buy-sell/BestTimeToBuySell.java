/**
 * Week 4 · S4 practice · L2 Best Time to Buy and Sell Stock
 *
 * One left-to-right pass. Track the lowest price so far and the best profit
 * of selling today. If prices only fall, the profit stays 0.
 * Time O(n), space O(1).
 */
public class BestTimeToBuySell {
    static int maxProfit(int[] prices) {
        int lowest = prices[0];
        int best = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - lowest;
            if (profit > best) {
                best = profit;
            }
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int a = maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        int b = maxProfit(new int[] {7, 6, 4, 3, 1});
        System.out.println(a);
        System.out.println(b);
        if (a != 5 || b != 0) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
