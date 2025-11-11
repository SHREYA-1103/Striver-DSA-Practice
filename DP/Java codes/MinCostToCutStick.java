// ---------------------------------- Ques ------------------------------
// Given a stick of length n and an array cuts[] representing positions at which you can cut the stick,
// return the minimum total cost of cutting the stick. 
// The cost of a cut is equal to the length of the stick being cut.
// ----------------------------------------------------------------------

import java.util.*;

public class MinCostToCutStick {

    // optimal - O(m^3), O(m^2)
    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] allCuts = new int[m + 2];
        allCuts[0] = 0;
        allCuts[m + 1] = n;
        for (int i = 0; i < m; i++) allCuts[i + 1] = cuts[i];
        Arrays.sort(allCuts);

        int dp[][] = new int[m + 2][m + 2];

        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i + len <= m + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = allCuts[j] - allCuts[i] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m + 1];
    }

    public static void main(String args[]) {
        int n = 7;
        int cuts[] = {1, 3, 4, 5};
        System.out.println(minCost(n, cuts)); // Output: 16
    }
}
