// ---------------------------------- Ques ------------------------------
// Given a set of distinct positive integers nums, return the largest subset such that 
// every pair (Si, Sj) of elements in this subset satisfies:
// Si % Sj == 0 or Sj % Si == 0.
// If there are multiple solutions, return any of them.
// ----------------------------------------------------------------------

import java.util.*;

public class LargestDivisibleSubset {

    // optimal - O(n^2), O(n)
    public static List<Integer> largestDivisibleSubset(int nums[]) {
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        int hash[] = new int[n];
        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> subset = new ArrayList<>();
        subset.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            subset.add(nums[lastIndex]);
        }

        Collections.reverse(subset);
        return subset;
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
    }
}
