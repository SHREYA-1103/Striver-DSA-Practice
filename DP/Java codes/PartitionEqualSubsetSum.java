// ---------------------------------- Ques ------------------------------
// Given an array of n positive integers, find if the given array can be partitioned into two subsets, such that both the subsets have equal sums.
// ----------------------------------------------------------------------


public class PartitionEqualSubsetSum {

    // O(n*sum of elements), O(n*sum of elements)
    public static boolean equalSumSubsets_tab(int arr[]){
        int n = arr.length;

        int targetSum = 0;

        for(int i=0; i<n; i++){
            targetSum += arr[i];
        }

        if(targetSum % 2 == 1) return false;

        targetSum /= 2;

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

    // O(n*sum of elements), O(sum of elements)
    public static boolean equalSumSubsets_so(int arr[]){
        int n = arr.length;

        int targetSum = 0;

        for(int i=0; i<n; i++){
            targetSum += arr[i];
        }

        if(targetSum % 2 == 1) return false;

        targetSum /= 2;
        
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
        int arr[] = {2,3,1,5,8};

        System.out.println(equalSumSubsets_tab(arr));

        System.out.println(equalSumSubsets_so(arr));
    }
}
