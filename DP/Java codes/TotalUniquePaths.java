import java.util.*;

public class TotalUniquePaths {

    // bruteforce (recursion) - O(2*mn), O(mn)
    public static int countPaths_rec(int rows, int cols, int row, int col){
        if(row < 0 || col < 0) return 0;

        if(row == 0 && col == 0) return 1;

        int left =  countPaths_rec(rows, cols, row, col-1);
        int up =  countPaths_rec(rows, cols, row-1, col);

        return left + up;
    }

    // better (DP memoization) - O(mn), O(mn)
    public static int countPaths_memo(int rows, int cols, int row, int col, int dp[][]){
        if(row < 0 || col < 0) return 0;

        if(row == 0 && col == 0) return dp[row][col] = 1;

        if(dp[row][col] != -1) return dp[row][col];

        int left =  countPaths_memo(rows, cols, row, col-1, dp);
        int up =  countPaths_memo(rows, cols, row-1, col, dp);

        return dp[row][col] = left + up;
    }

    // optimal1 (DP tabulation) - O(mn), O(mn)
    public static int countPaths_tab(int rows, int cols, int row, int col){
        int dp[][] = new int[rows][cols];

        dp[0][0] = 1;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } 
                else {
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    dp[i][j] = left + up;
                }
            }
        }

        return dp[rows-1][cols-1];
    }

    // optimal2 (DP tabulation space optimized) - O(mn), O(n)
    public static int countPaths_so(int rows, int cols, int row, int col){
        int dp[] = new int[cols];

        for(int i=0; i<rows; i++){
            int temp[] = new int[cols];
            for(int j=0; j<cols; j++){
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                } 
                else {
                    int left = j > 0 ? temp[j - 1] : 0;
                    int up = dp[j];
                    temp[j] = left + up;
                }
            }
            dp = temp;
        }

        return dp[cols-1];
    }
     
    public static void main(String args[]){
        int m = 2;
        int n = 3;

        System.out.println(countPaths_rec(m, n, m-1, n-1));

        int dp[][] = new int[m][n];
        for(int arr[]:dp){
            Arrays.fill(arr, -1);
        }
        System.out.println(countPaths_memo(m, n, m-1, n-1, dp));

        System.out.println(countPaths_tab(m, n, m-1, n-1));

        System.out.println(countPaths_so(m, n, m-1, n-1));
    }

}
