// ---------------------------------- Ques ------------------------------
// You are given an array prices where prices[i] is the price of a stock on the ith day.
// You may complete as many transactions as you like, but after you sell your stock, 
// you cannot buy stock for the next k days (i.e., cooldown of k days).
// Return the maximum profit you can achieve.
// ----------------------------------------------------------------------

public class BuyAndSellStocksWithCooldown {

    // optimal - O(n*k), O(n)
    public static int maxProfit(int prices[], int k) {
        int n = prices.length;
        if (n == 0) return 0;

        int hold = -prices[0]; // max profit holding stock
        int sold = 0;           // max profit just sold stock
        int[] rest = new int[n]; // max profit at rest

        for (int i = 1; i < n; i++) {
            int prevSold = sold;
            sold = hold + prices[i];

            int maxRest = 0;
            if (i - k - 1 >= 0) {
                maxRest = rest[i - k - 1];
            }
            hold = Math.max(hold, maxRest - prices[i]);

            rest[i] = Math.max(rest[i - 1], prevSold);
        }

        return Math.max(sold, rest[n - 1]);
    }

    public static void main(String args[]) {
        int prices[] = {1, 2, 3, 0, 2, 4, 1};
        int k = 2;
        System.out.println(maxProfit(prices, k));
    }
}