// ---------------------------------- Ques ------------------------------
// Given an integer array nums, return the length of the longest bitonic subsequence.
// A bitonic subsequence is a sequence that first increases and then decreases.
// ----------------------------------------------------------------------

public class LongestBitonicSubsequence {

    // optimal - O(n^2), O(n)
    public static int longestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        // Longest Increasing Subsequence
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Longest Decreasing Subsequence
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, lis[i] + lds[i] - 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(longestBitonicSequence(nums));
    }
}
