// ---------------------------------- Ques ------------------------------
// Given an integer array nums, return the length of the longest strictly increasing subsequence.
// A subsequence is a sequence derived from the array by deleting some or no elements 
// without changing the order of the remaining elements.
// ----------------------------------------------------------------------

public class LongestIncreasingSubsequence {

    // optimal - O(n^2), O(n)
    public static int lengthOfLIS(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String args[]) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
