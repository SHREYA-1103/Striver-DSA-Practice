// ---------------------------------- Ques ------------------------------
// Given an array of n positive integers and a target diff, find the total number of partitions (splitting array into two subsets) that can be done such that the absolute difference between the sum of elements if the two subsets is equal to the given target diff.
// ----------------------------------------------------------------------


public class CountPartitionsWithGivenDiff {

    // O(n*targetSum), O(n*targetSum)
    public static int countPartitions_tab(int arr[], int targetDiff){
        int n = arr.length;

        int totalSum = 0;

        for(int i=0; i<n; i++){
            totalSum+=arr[i];
        }

        int targetSum = (totalSum-targetDiff)/2;
        
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
    public static int countPartitions_so(int arr[], int targetDiff){
        int n = arr.length;
        
        int totalSum = 0;

        for(int i=0; i<n; i++){
            totalSum+=arr[i];
        }

        int targetSum = (totalSum-targetDiff)/2;
        
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
        int targetDiff = 0;

        System.out.println(countPartitions_tab(arr, targetDiff));

        System.out.println(countPartitions_so(arr, targetDiff));
    }
}
