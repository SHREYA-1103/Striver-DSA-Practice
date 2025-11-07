import java.util.*;

public class LongestIncreasingSubsequence {

    // Bruteforce (recursion) - O(2^n), O(2^n)
    public static int LIS_rec(int arr[]){
        return recHelper(arr, -1, 0);
    }

    public static int recHelper(int arr[], int prev, int ind){
        if(ind == arr.length) return 0;

        if(prev == -1 || arr[ind] > arr[prev]){ // forms increasing subsequence
            // pick or not pick
            return Math.max(recHelper(arr, prev, ind+1), 1+recHelper(arr, ind, ind+1));
        }

        else{
            // not pick
            return recHelper(arr, prev, ind+1);
        }
    }

    // Better (DP memoization) - O(n^2), O(2^n)
    public static int LIS_memo(int arr[], int dp[][]){
        return memoHelper(arr, -1, 0, dp);
    }

    public static int memoHelper(int arr[], int prev, int ind, int dp[][]){
        if(ind == arr.length) return 0;

        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];

        if(prev == -1 || arr[ind] > arr[prev]){ // forms increasing subsequence
            // pick or not pick
            return dp[ind][prev+1] = Math.max(memoHelper(arr, prev, ind+1, dp), 1+memoHelper(arr, ind, ind+1, dp));
        }

        else{
            // not pick
            return dp[ind][prev+1] = memoHelper(arr, prev, ind+1, dp);
        }
    }

    // Optimal1 (DP tabulation) - O(n^2), O(n^2)
    public static int LIS_tab(int arr[]){
        int n = arr.length;
        
        int dp[][] = new int[n+1][n+1];

        int[] arr1 = arr.clone();
        Arrays.sort(arr1);

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i-1] == arr1[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        int row = n;
        int col = n;

        while(dp[row][col] != 0){
            if(dp[row][col] == dp[row-1][col-1]+1){
                System.out.print(arr[row-1] + " ");
                row-=1;
                col-=1;
            }
            else{
                if(dp[row][col] == dp[row-1][col]){
                    row-=1;
                }
                else{
                    col-=1;
                }
            }
        }

        return dp[n][n];
    }

    // Optimal2 (DP tabulation space optimized) - O(n^2), O(n) 
    public static int LIS_so(int arr[]){
        int n = arr.length;
        
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
    
    public static void main(String args[]){
        int arr[] = {1,4,2,6,8,5};

        System.out.println(LIS_rec(arr));

        int dp[][] = new int[arr.length+1][arr.length+1];
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        System.out.println(LIS_memo(arr, dp));

        System.out.println(LIS_tab(arr));

        System.out.println(LIS_so(arr));
    }   
}
