//----------------------------- Ques ------------------------------------
// Given an array of integers, two allowed operations, '+' and '-' and a target value, find the total number of ways in which one of the two allowed operations can be inserted as a prefix to every element such that the reuslt of the operation is equal to the given target value.
//-----------------------------------------------------------------------


public class TargetSum {
    
    public static int countWays_tab(int arr[], int target){
        int n = arr.length;

        int totalSum = 0;

        for(int i=0; i<n; i++){
            totalSum+=arr[i];
        }

        if(Math.abs(target) > totalSum || (totalSum-target)%2!=0) return -1;

        int targetSum = (totalSum-target)/2;
        
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

        return dp[n][targetSum] == 0 ? -1 : dp[n][targetSum];
    }

    public static int countWays_so(int arr[], int target){
        int n = arr.length;
        
        int totalSum = 0;

        for(int i=0; i<n; i++){
            totalSum+=arr[i];
        }

        if(Math.abs(target) > totalSum || (totalSum-target)%2!=0) return -1;

        int targetSum = (totalSum-target)/2;
        
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int num : arr) {
            if(num == 0){
                for(int j=0; j<=targetSum; j++) dp[j]*=2;
            }
            else{
                for (int sum = targetSum; sum >= num; sum--) {
                    dp[sum] += dp[sum - num];
                }
            }  
        }

        return dp[targetSum] == 0 ? -1 : dp[targetSum];
    }

    public static void main(String args[]){
        int arr[] = {1,2,3,2};
        int target = 0;

        System.out.println(countWays_tab(arr, target));

        System.out.println(countWays_so(arr, target));
    }
}
