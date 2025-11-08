// ------------------------------ Ques ----------------------------------
// Given a triangular grid, that is, a grid with m rows and ith row with i+1 elements. In every step, you can move to either i or i+1 index in the (j+1)th row. Find the min path sum starting from the first row to any index in the last row.
// ----------------------------------------------------------------------


public class DPonTriangularGrid {

    // O(n^2), O(n^2)
    public static int minPathSum_tab(int grid[][]){
        int m = grid.length;

        int dp[][] = new int[m][m];

        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<=i; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if(j == 0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else if(j == i) dp[i][j] = dp[i-1][j-1] + grid[i][j];
                else dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + grid[i][j];
                if(i == m-1) minSum = Math.min(minSum, dp[i][j]);
            }
        }

        return minSum;
    }

    // O(n^2), O(n)
    public static int minPathSum_so(int grid[][]){
        int m = grid.length;

        int dp[] = new int[m];
        int temp[] = new int[m];

        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<=i; j++){
                if(i == 0 && j == 0) dp[j] = grid[i][j];
                else if(j == 0) dp[j] = temp[j] + grid[i][j];
                else if(j == i) dp[j] = temp[j-1] + grid[i][j];
                else dp[j] = Math.min(temp[j-1], temp[j]) + grid[i][j];
                if(i == m-1) minSum = Math.min(minSum, dp[j]);
            }
            temp = dp.clone();
        }

        return minSum;
    }
    
    public static void main(String args[]){
        int grid[][] = {{1}, {2,3}, {3,6,7}, {8,9,6,7}};

        System.out.println(minPathSum_tab(grid));

        System.out.println(minPathSum_so(grid));
    }
}
