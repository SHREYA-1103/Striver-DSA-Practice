// -------------------------------- Ques --------------------------------
// Given an array of coins, denoting the various denominations of coins available along with a target value, find the total number of ways in which the desired coins can be used to achieve the target sum. Assume there is unlimited supply of each coin available.
// ----------------------------------------------------------------------


public class CountCoinChangeWays {

    // O(n*target), O(n*target)
    public static int countWays_tab(int coins[], int target){
        int n = coins.length;

        int dp[][] = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (coins[i - 1] <= j) {
                    // pick or not pick
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    // not pick
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    // O(n*target), O(target)
    public static int countWays_so(int coins[], int target){
        int n = coins.length;

        int dp[] = new int[target + 1];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= target; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[target] == Integer.MAX_VALUE - 1 ? -1 : dp[target];
    }
    
    public static void main(String args[]){
        int coins[] = {5, 6, 9};
        int target = 3;

        System.out.println(countWays_tab(coins, target));

        System.out.println(countWays_so(coins, target));
    }
}
