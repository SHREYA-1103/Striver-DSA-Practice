// ---------------------------------- Ques ------------------------------
// Given a sequence of matrices, find the minimum number of scalar multiplications 
// needed to multiply the sequence of matrices.
// You are given an array arr[] such that the ith matrix has dimensions arr[i-1] x arr[i].
// ----------------------------------------------------------------------

public class MCMBottomUp {

    // optimal - O(n^3), O(n^2)
    public static int matrixChainOrder(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String args[]) {
        int arr[] = {40, 20, 30, 10, 30};
        System.out.println(matrixChainOrder(arr));
    }
}