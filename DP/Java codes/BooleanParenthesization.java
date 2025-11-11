// ---------------------------------- Ques ------------------------------
// Given a boolean expression string consisting of symbols 'T' (true), 'F' (false) 
// and operators '&', '|', '^', count the number of ways the expression can be parenthesized 
// such that the value of the expression evaluates to true.
// ----------------------------------------------------------------------

import java.util.*;

public class BooleanParenthesization {

    // optimal - O(n^3), O(n^2)
    public static int countWays(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][2]; // 0 -> false, 1 -> true
        for (int[][] mat : dp) for (int[] arr : mat) Arrays.fill(arr, -1);
        return solve(s, 0, n - 1, 1, dp);
    }

    private static int solve(String s, int i, int j, int isTrue, int[][][] dp) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1) return s.charAt(i) == 'T' ? 1 : 0;
            else return s.charAt(i) == 'F' ? 1 : 0;
        }
        if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            char op = s.charAt(k);
            int lT = solve(s, i, k - 1, 1, dp);
            int lF = solve(s, i, k - 1, 0, dp);
            int rT = solve(s, k + 1, j, 1, dp);
            int rF = solve(s, k + 1, j, 0, dp);

            switch (op) {
                case '&' -> ans += (isTrue == 1 ? lT * rT : lF * rF + lF * rT + lT * rF);
                case '|' -> ans += (isTrue == 1 ? lT * rT + lF * rT + lT * rF : lF * rF);
                case '^' -> ans += (isTrue == 1 ? lT * rF + lF * rT : lT * rT + lF * rF);
                default -> {
                }
            }
        }
        return dp[i][j][isTrue] = ans;
    }

    public static void main(String args[]) {
        String expr = "T|F&T^F";
        System.out.println(countWays(expr)); // Output: 5
    }
}
