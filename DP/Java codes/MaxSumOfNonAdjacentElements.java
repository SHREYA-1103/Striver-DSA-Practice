import java.util.*;

public class MaxSumOfNonAdjacentElements{

    // bruteforce (recursion) - O(2^n), O(2^n)
    public static int maxSum_rec(int nums[], int idx){
        if(idx == 0){
            return nums[idx];
        }

        if(idx < 0){
            return 0;
        }

        int pick = nums[idx] + maxSum_rec(nums, idx-2); // since adjacent elements are not allowed
        
        int notPick = maxSum_rec(nums, idx-1);

        return Math.max(pick, notPick);
    }

    // better (DP memoization) - O(n), O(2n)
    public static int maxSum_memo(int nums[], int idx, int dp[]){
        if(idx == 0){
            return dp[idx] = nums[idx];
        }

        if(idx < 0){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int pick = nums[idx] + maxSum_memo(nums, idx-2, dp); // since adjacent elements are not allowed
        
        int notPick = maxSum_memo(nums, idx-1, dp);

        return Math.max(pick, notPick);
    }

    // optimal1 (DP tabulation) - O(n), O(n)
    public static int maxSum_tab(int nums[]){
        int n = nums.length;
        
        int dp[] = new int[n];

        dp[0] = nums[0];

        for(int i=1; i<n; i++){
            int pick = i>1 ? nums[i] + dp[i-2] : nums[i];

            int notPick = i>0 ? dp[i-1] : 0;
             
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }

    // optimal2 (DP tabulation space optimized) - O(n), O(1)
    public static int maxSum_so(int nums[]){
        int n = nums.length;

        if(n == 0) return 0;

        int maxa = 0;
        int maxb = nums[0];

        for(int i=1; i<n; i++){
            int pick = i > 1 ? nums[i]+maxa : nums[i];
            
            int notPick = 0+maxb;

            maxa = maxb;
            maxb = Math.max(pick, notPick);
        }

        return Math.max(maxa, maxb);
    }

    public static void main(String args[]){
        int nums[] = {2,1,1,2};

        System.out.println(maxSum_rec(nums, nums.length-1));

        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(maxSum_memo(nums, nums.length-1, dp));

        System.out.println(maxSum_tab(nums));

        System.out.println(maxSum_so(nums));
    }
}