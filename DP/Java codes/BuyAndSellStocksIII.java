// ---------------------------------- Ques ------------------------------
// You are given an array prices where prices[i] is the price of a stock on the ith day.
// Find the maximum profit you can achieve with at most two transactions.
// Note: You may not engage in multiple transactions at the same time 
// (i.e., you must sell the stock before you buy again).
// ----------------------------------------------------------------------

public class BuyAndSellStocksIII {

    // optimal - O(n), O(1)
    public static int maxProfit(int prices[]) {
        int buy1 = Integer.MAX_VALUE;
        int profit1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int profit2 = 0;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }

        return profit2;
    }

    public static void main(String args[]) {
        int prices[] = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }
}
