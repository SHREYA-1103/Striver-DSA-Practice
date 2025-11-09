// ---------------------------------- Ques ------------------------------
// Given an array of n positive integers and a target sum, find if there exists any subset int he array such that the sum of number sin the subset equals the target sum.
// ----------------------------------------------------------------------


public class SubsetSumEqualToTarget {

    // O(n*targetSum), O(n*targetSum)
    public static boolean targetSumExists_tab(int arr[], int targetSum){
        int n = arr.length;

        boolean dp[][] = new boolean[n+1][targetSum+1];

        for(int i=0; i<n+1; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=targetSum; j++){
                if(j >= arr[i-1]){
                    // take or not take - choose
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    // no choice - leave that
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][targetSum];
    }

    // O(n*targetSum), O(targetSum)
    public static boolean targetSumExists_so(int arr[], int targetSum){
        int n = arr.length;

        boolean dp[] = new boolean[targetSum+1];
        boolean temp[] = new boolean[targetSum+1];

        dp[0] = true;
        temp[0] = true;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=targetSum; j++){
                if(j >= arr[i-1]){
                    // take or not take - choose
                    dp[j] = temp[j-arr[i-1]] || temp[j];
                }
                else{
                    // no choice - leave that
                    dp[j] = temp[j];
                }
            }
            temp = dp.clone();
        }

        return dp[targetSum];
    }
    
    public static void main(String args[]){
        int arr[] = {2,3,1,5,7};
        int targetSum = 10;

        System.out.println(targetSumExists_tab(arr, targetSum));

        System.out.println(targetSumExists_so(arr, targetSum));
    }
}
