package sprint;

/**
 * SPRINT WRITE 2026-07-06 — Best Time to Buy and Sell Stock (LeetCode #121)
 * Cold boilerplate rep for SRS Sprint Day+3. No card, no cheatsheet.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int best = 0, ref = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= ref) ref = prices[i];
            else best = Math.max(best, prices[i] - ref);
        }
        return best;
    }

    // --- Test ---
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();

        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // Expected: 5
        System.out.println(sol.maxProfit(new int[]{7, 6, 4, 3, 1}));    // Expected: 0
        System.out.println(sol.maxProfit(new int[]{3, 5, 1, 4}));       // Expected: 3
        System.out.println(sol.maxProfit(new int[]{2, 4, 1}));          // Expected: 2
        System.out.println(sol.maxProfit(new int[]{1}));                // Expected: 0
        System.out.println(sol.maxProfit(new int[]{1, 2}));             // Expected: 1
        System.out.println(sol.maxProfit(new int[]{5, 5, 5}));          // Expected: 0
    }
}
