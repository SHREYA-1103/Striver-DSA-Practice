// ------------------------------ Ques ----------------------------------
// Given a rectangular grid, of size m*n, that is, a grid with m rows and n columns in each row. In every step, you can move to either i-1 or i or i+1 index in the (j+1)th row. Find the max path sum starting from the any index in the first row to any index in the last row.
// ----------------------------------------------------------------------


public class MaxFallingPathSum {

    // O(n^2), O(n^2)
    public static int maxPathSum_tab(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0) dp[i][j] = grid[i][j];
                else if(j == 0) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]) + grid[i][j];
                else if(j == n-1) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + grid[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i-1][j+1])) + grid[i][j];
                if(i == m-1) maxSum = Math.max(maxSum, dp[i][j]);
            }
        }

        return maxSum;
    }

    // O(n^2), O(n)
    public static int maxPathSum_so(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        int dp[] = new int[n];
        int temp[] = new int[n];

        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0) dp[j] = grid[i][j];
                else if(j == 0) dp[j] = Math.max(temp[j], temp[j+1]) + grid[i][j];
                else if(j == n-1) dp[j] = Math.max(temp[j], temp[j-1]) + grid[i][j];
                else dp[j] = Math.max(temp[j-1], Math.max(temp[j], temp[j+1])) + grid[i][j];
                if(i == m-1) maxSum = Math.max(maxSum, dp[j]);
            }
            temp = dp.clone();
        }

        return maxSum;
    }
    
    public static void main(String args[]){
        int grid[][] = {{1,2,3,4}, {2,1,2,3}, {1,2,3,4}};

        System.out.println(maxPathSum_tab(grid));

        System.out.println(maxPathSum_so(grid));
    }
}
