import java.util.*;

public class HouseRobberII {

    // Brute force (recursion) - O(2^n), O(n) stack
    public static int maxSum_rec(int nums[], int idx) {
        if (idx == 0) return nums[0];
        if (idx < 0) return 0;

        int pick = nums[idx] + maxSum_rec(nums, idx - 2);
        int notPick = maxSum_rec(nums, idx - 1);

        return Math.max(pick, notPick);
    }

    // Better (DP Memoization) - O(n), O(n)
    public static int maxSum_memo(int nums[], int idx, int dp[]) {
        if (idx == 0) return nums[0];
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + maxSum_memo(nums, idx - 2, dp);
        int notPick = maxSum_memo(nums, idx - 1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    // Optimal (DP Tabulation) - O(n), O(n)
    public static int maxSum_tab(int nums[]) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    public static void main(String args[]) {
        // Example input
        int nums[] = {2};

        if (nums.length == 0) {
            System.out.println(0);
            return;
        }
        if (nums.length == 1) {
            System.out.println(nums[0]);
            return;
        }

        // Split into two cases: exclude last or exclude first
        int nums1[] = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int nums2[] = Arrays.copyOfRange(nums, 1, nums.length);

        System.out.println(Math.max(
            maxSum_rec(nums1, nums1.length - 1),
            maxSum_rec(nums2, nums2.length - 1)
        ));

        int dp1[] = new int[nums1.length];
        Arrays.fill(dp1, -1);
        int dp2[] = new int[nums2.length];
        Arrays.fill(dp2, -1);

        System.out.println(Math.max(
            maxSum_memo(nums1, nums1.length - 1, dp1),
            maxSum_memo(nums2, nums2.length - 1, dp2)
        ));

        System.out.println(Math.max(maxSum_tab(nums1), maxSum_tab(nums2)));
    }
}
