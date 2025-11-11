// ---------------------------------- Ques ------------------------------
// You are given an integer k and an array prices where prices[i] is the price of a stock on the ith day.
// Find the maximum profit you can achieve with at most k transactions.
// Note: You may not engage in multiple transactions at the same time 
// (i.e., you must sell the stock before you buy again).
// ----------------------------------------------------------------------

public class BuyAndSellStocksIV {

    // optimal - O(n*k), O(n*k)
    public static int maxProfit(int k, int prices[]) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        int dp[][] = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i]);
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String args[]) {
        int k = 2;
        int prices[] = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(k, prices));
    }
}
