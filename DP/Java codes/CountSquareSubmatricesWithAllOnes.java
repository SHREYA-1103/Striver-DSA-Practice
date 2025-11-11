// ---------------------------------- Ques ------------------------------
// Given a m x n binary matrix mat, return the number of square submatrices that have all ones.
// ----------------------------------------------------------------------

public class CountSquareSubmatricesWithAllOnes {

    // optimal - O(m*n), O(n)
    public static int countSquares(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] dp = new int[n];
        int total = 0;

        for (int i = 0; i < m; i++) {
            int prev = 0; // stores dp[j-1] from previous row
            for (int j = 0; j < n; j++) {
                int temp = dp[j];
                if (mat[i][j] == 1) {
                    if (i == 0 || j == 0) dp[j] = 1;
                    else dp[j] = 1 + Math.min(Math.min(dp[j], dp[j - 1]), prev);
                    total += dp[j];
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }

        return total;
    }

    public static void main(String args[]) {
        int[][] mat = {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        };
        System.out.println(countSquares(mat)); // Output: 15
    }
}
