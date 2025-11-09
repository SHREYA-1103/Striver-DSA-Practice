// ---------------------------------- Ques ------------------------------
// Given an array of n positive integers and a target sum, find the total number of subsets which have the sum of elements equal to the given target sum k.
// ----------------------------------------------------------------------


public class CountSubsetsWithSumK {

    // O(n*targetSum), O(n*targetSum)
    public static int countSubsets_tab(int arr[], int targetSum){
        int n = arr.length;
        int[][] dp = new int[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= targetSum; sum++) {
                // not take
                dp[i][sum] = dp[i - 1][sum];
                // take if possible
                if (arr[i - 1] <= sum) {
                    dp[i][sum] += dp[i - 1][sum - arr[i - 1]];
                }
            }
        }

        return dp[n][targetSum];
    }

    // O(n*targetSum), O(targetSum)
    public static int countSubsets_so(int arr[], int targetSum){
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int sum = targetSum; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[targetSum];
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,2,3};
        int targetSum = 4;

        System.out.println(countSubsets_tab(arr, targetSum));

        System.out.println(countSubsets_so(arr, targetSum));
    }
}
