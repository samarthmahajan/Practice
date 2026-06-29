package arrays;

/**
 * LeetCode #121 - Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Given daily prices, buy on one day and sell on a later day for one transaction.
 * Return the maximum achievable profit, or 0 if none is possible.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
       int left=0, right = 1, max =0;
       while (right< prices.length){
           int profit = prices[right]- prices[left];
           if (profit<=0){
               left=right;
               right++;
           } else {
               right++;
               max = Math.max(max, profit);
           }
       }

       return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();

        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // expected 5
        System.out.println(sol.maxProfit(new int[]{7, 6, 4, 3, 1}));    // expected 0
        System.out.println(sol.maxProfit(new int[]{1, 2}));            // expected 1
        System.out.println(sol.maxProfit(new int[]{2, 4, 1}));        // expected 2
    }
}
