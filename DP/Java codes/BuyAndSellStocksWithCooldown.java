// ---------------------------------- Ques ------------------------------
// You are given an array prices where prices[i] is the price of a stock on the ith day.
// You may complete as many transactions as you like, but after you sell your stock, 
// you cannot buy stock on the next day (i.e., cooldown of one day).
// Return the maximum profit you can achieve.
// ----------------------------------------------------------------------

public class BuyAndSellStocksWithCooldown {

    // optimal - O(n), O(1)
    public static int maxProfit(int prices[]) {
        int n = prices.length;
        if (n == 0) return 0;

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < n; i++) {
            int prevSold = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, prevSold);
        }

        return Math.max(sold, rest);
    }

    public static void main(String args[]) {
        int prices[] = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
