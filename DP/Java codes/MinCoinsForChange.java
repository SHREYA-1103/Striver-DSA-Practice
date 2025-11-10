// -------------------------------- Ques --------------------------------
// Given an array of coins, denoting the various denominations of coins available along with a target value, find the minimum number of coins, from the given set of coins, needed to achieve that target value. Assume there is unlimited supply of each coin available.
// ----------------------------------------------------------------------


public class MinCoinsForChange {

    // O(n*target), O(n*target)
    public static int minCoins_tab(int coins[], int target){
        int n = coins.length;

        int dp[][] = new int[n + 1][target + 1];

        for (int j = 0; j <= target; j++) dp[0][j] = Integer.MAX_VALUE - 1;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target] == Integer.MAX_VALUE - 1 ? -1 : dp[n][target];
    }

    // O(n*target), O(target)
    public static int minCoins_so(int coins[], int target){
        int n = coins.length;

        int dp[] = new int[target + 1];

        for (int j = 1; j <= target; j++) dp[j] = Integer.MAX_VALUE - 1;
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= target; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE - 1) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }

        return dp[target] == Integer.MAX_VALUE - 1 ? -1 : dp[target];
    }
    
    public static void main(String args[]){
        int coins[] = {1, 5, 6, 9};
        int target = 11;

        System.out.println(minCoins_tab(coins, target));

        System.out.println(minCoins_so(coins, target));
    }
}
