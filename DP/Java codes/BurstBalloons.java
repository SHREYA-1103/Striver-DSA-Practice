// ---------------------------------- Ques ------------------------------
// You are given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
// When you burst balloon i, you gain nums[i - 1] * nums[i] * nums[i + 1] coins. 
// If i-1 or i+1 goes out of bounds, consider it as 1.
// Return the maximum coins you can collect by bursting the balloons wisely.
// ----------------------------------------------------------------------

public class BurstBalloons {

    // optimal - O(n^3), O(n^2)
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];
        n += 2;

        int dp[][] = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int left = 0; left < n - len; left++) {
                int right = left + len;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                        arr[left] * arr[i] * arr[right] + dp[left][i] + dp[i][right]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String args[]) {
        int nums[] = {3, 1, 5, 8};
        System.out.println(maxCoins(nums)); // Output: 167
    }
}