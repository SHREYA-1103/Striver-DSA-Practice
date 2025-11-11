// ---------------------------------- Ques ------------------------------
// Given an integer array nums, return the number of longest increasing subsequences.
// A subsequence is strictly increasing and can be derived by deleting some elements 
// without changing the order of the remaining elements.
// ----------------------------------------------------------------------

public class CountLIS {

    // optimal - O(n^2), O(n)
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            length[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, length[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (length[i] == maxLen) total += count[i];
        }

        return total;
    }

    public static void main(String args[]) {
        int nums[] = {1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(nums)); // Output: 2
    }
}
