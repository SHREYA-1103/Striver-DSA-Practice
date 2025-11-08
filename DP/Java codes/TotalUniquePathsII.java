import java.util.*;

public class TotalUniquePathsII {

    static int mod = 1000000007;

    // better (DP memoization) - O(mn), O(mn + recursion)
    public static int countPaths_memo(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        
        memoHelper(m-1, n-1, matrix, dp);

        return dp[m-1][n-1] % mod;
    }
    
    public static int memoHelper(int i, int j, int matrix[][], int dp[][]){
        if(i >= 0 && j >= 0 && matrix[i][j] == -1){
            return 0;
        }

        if(i == 0 || j == 0) return 1;

        if(i < 0 && j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int up = memoHelper(i-1, j, matrix, dp);
        int left = memoHelper(i, j-1, matrix, dp);
        return dp[i][j] = (up+left) % mod;
    }

    // Optimal - O(mn), O(mn)
    public static int countPaths_tab(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][]= new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = (up+left) % mod;
                }
                
            }
        }
        
        return dp[m-1][n-1];
    }

    // Optimal - O(mn), O(n)
    public static int countPaths_so(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[] = new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -1) dp[j] = 0;
                else if(i == 0 && j == 0) dp[j] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = dp[j];
                    if(j > 0) left = dp[j-1];
                    dp[j] = (up+left) % mod;
                }
                
            }
        }
        
        return dp[n-1];
    }
    
    public static void main(String args[]){
        int matrix[][] = {{0,0,0}, {0,-1,0}, {0,0,0}};

        System.out.println(countPaths_memo(matrix));

        System.out.println(countPaths_tab(matrix));

        System.out.println(countPaths_so(matrix));
    }
}
