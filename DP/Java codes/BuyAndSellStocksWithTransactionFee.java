// ---------------------------------- Ques ------------------------------
// You are given an array prices where prices[i] is the price of a stock on the ith day, 
// and an integer fee representing a transaction fee.
// You may complete as many transactions as you like, but you must pay the transaction fee 
// for each sale. You may not hold multiple stocks at the same time.
// Return the maximum profit you can achieve.
// ----------------------------------------------------------------------

public class BuyAndSellStocksWithTransactionFee {

    // optimal - O(n), O(1)
    public static int maxProfit(int prices[], int fee) {
        int n = prices.length;
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }

    public static void main(String args[]) {
        int prices[] = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}
