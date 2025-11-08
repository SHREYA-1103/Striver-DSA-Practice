//----------------------------- Ques ------------------------------------
// Given an m*n grid with an associated weight for each cell, find the minimum cost of the path from (0,0) to (m-1, n-1). Assume you can only move right or down at any point in time.
//-----------------------------------------------------------------------


public class MinPathSumInGrid {

    static int mod = 1000000007;
    
    // Optimal - O(mn), O(mn)
    public static int minCostPath_tab(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        int dp[][]= new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = (Math.min(left, up) + grid[i][j]) % mod; 
                }
                
            }
        }
        
        return dp[m-1][n-1];
    }

    // Optimal - O(mn), O(mn)
    public static int minCostPath_so(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        int dp[]= new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0) dp[j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i > 0) up = dp[j];
                    if(j > 0) left = dp[j-1];
                    dp[j] = (Math.min(left, up) + grid[i][j]) % mod; 
                }
                
            }
        }
        
        return dp[n-1];
    }
    
    public static void main(String args[]){
        int grid[][] = {{5,9,6}, {11,5,2}};

        System.out.println(minCostPath_tab(grid));

        System.out.println(minCostPath_so(grid));
    }
}
