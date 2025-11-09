// ---------------------------------- Ques ------------------------------
// Given an array of n positive integers, Partition the given array into two subsets, such that the absolute difference of sum of the elements in each of them is minimum.
// ----------------------------------------------------------------------


public class PartitionArrayIntoTwoMinAbsoluteDiffSumSubsets {

    // O(n*sum of elements), O(n*sum of elements)
    public static int equalSumSubsets_tab(int arr[]){
        int n = arr.length;

        int sum = 0;

        for(int i=0; i<n; i++){
            sum += arr[i];
        }

        int targetSum = sum / 2;

        boolean dp[][] = new boolean[n+1][targetSum+1];

        for(int i=0; i<n+1; i++){
            dp[i][0] = true;
        }

        int max = 0;

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
                if(i == n-1 && dp[i][j]) max = j;
            }
        }

        return sum - 2*max;
    }

    // O(n*sum of elements), O(sum of elements)
    public static int equalSumSubsets_so(int arr[]){
        int n = arr.length;

        int sum = 0;

        for(int i=0; i<n; i++){
            sum += arr[i];
        }

        int targetSum = sum / 2;
        
        boolean dp[] = new boolean[targetSum+1];
        boolean temp[] = new boolean[targetSum+1];

        dp[0] = true;
        temp[0] = true;

        int max = 0;

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
                if(i == n-1) max = j;
            }
            temp = dp.clone();
        }

        return sum - 2*max;
    }
    
    public static void main(String args[]){
        int arr[] = {2,3,1,5,8};

        System.out.println(equalSumSubsets_tab(arr));

        System.out.println(equalSumSubsets_so(arr));
    }
}
