// ---------------------------------- Ques ------------------------------
// Given an integer array nums, print one of the longest strictly increasing subsequences.
// A subsequence is a sequence derived from the array by deleting some or no elements 
// without changing the order of the remaining elements.
// ----------------------------------------------------------------------

import java.util.*;

public class PrintLIS {

    // optimal - O(n^2), O(n)
    public static void printLIS(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lis.add(nums[lastIndex]);
        }

        Collections.reverse(lis);
        System.out.println(lis);
    }

    public static void main(String args[]) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        printLIS(nums);
    }
}
