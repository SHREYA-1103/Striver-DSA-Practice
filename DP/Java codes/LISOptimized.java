// ---------------------------------- Ques ------------------------------
// Given an integer array nums, return the length of the longest strictly increasing subsequence.
// Optimize the solution using binary search to achieve O(n log n) time complexity.
// ----------------------------------------------------------------------

import java.util.*;

public class LISOptimized {

    // optimal - O(n log n), O(n)
    public static int lengthOfLIS(int nums[]) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int idx = Collections.binarySearch(temp, nums[i]);
                if (idx < 0) idx = -idx - 1;
                temp.set(idx, nums[i]);
            }
        }

        return temp.size();
    }

    public static void main(String args[]) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
