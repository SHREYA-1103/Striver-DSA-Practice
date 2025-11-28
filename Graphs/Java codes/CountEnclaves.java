public class CountEnclaves {

    public static void dfs(int grid[][], boolean vis[][], int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        
        if(row < 0 || row > m-1 || col < 0 || col > n-1 || vis[row][col] || grid[row][col] == 0) return;

        vis[row][col] = true;

        dfs(grid, vis, row-1, col);
        dfs(grid, vis, row, col+1);
        dfs(grid, vis, row+1, col);
        dfs(grid, vis, row, col-1);
    }

    // O(mn), O(mn)
    public static int countEnclaves(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        // boundary traversals
        // top boundary
        for(int j=0; j<n; j++){
            if(grid[0][j] == 1 && !vis[0][j]){
                dfs(grid, vis, 0, j);
            }
        }

        // left boundary
        for(int i=0; i<m; i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(grid, vis, i, 0);
            }
        }

        // bottom boundary
        for(int j=0; j<n; j++){
            if(grid[m-1][j] == 1 && !vis[m-1][j]){
                dfs(grid, vis, m-1, j);
            }
        }

        // right boundary
        for(int i=0; i<m; i++){
            if(grid[i][n-1] == 1 && !vis[i][n-1]){
                dfs(grid, vis, i, n-1);
            }
        }

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }

        return count;
    }
    
    public static void main(String args[]){
        int grid[][] = {   {0,0,0,1,1},
                            {0,0,1,1,0},
                            {0,1,0,0,0}, 
                            {0,1,1,0,0},
                            {0,0,0,1,1}
                        };

        System.out.println(countEnclaves(grid));
    }
}
