// ---------------------------------- Ques ------------------------------
// You are given an integer array prices where prices[i] is the price of a stock on the ith day.
// On each day, you may decide to buy and/or sell the stock. 
// You can hold at most one share of the stock at a time but can buy again after selling.
// Return the maximum profit you can achieve.
// ----------------------------------------------------------------------

public class BuyAndSellStockII {

    // optimal - O(n), O(1)
    public static int maxProfit(int prices[]) {
        int n = prices.length;
        int profit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String args[]) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
