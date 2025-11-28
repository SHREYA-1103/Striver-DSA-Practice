public class SurroundedRegions {

    public static void dfs(char grid[][], boolean vis[][], int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        
        if(row < 0 || row > m-1 || col < 0 || col > n-1 || vis[row][col] || grid[row][col] == 'X') return;

        vis[row][col] = true;

        dfs(grid, vis, row-1, col);
        dfs(grid, vis, row, col+1);
        dfs(grid, vis, row+1, col);
        dfs(grid, vis, row, col-1);
    }

    // O(mn), O(mn)
    public static void updateMatrix(char grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        // boundary traversals
        // top boundary
        for(int j=0; j<n; j++){
            if(grid[0][j] == 'O' && !vis[0][j]){
                dfs(grid, vis, 0, j);
            }
        }

        // left boundary
        for(int i=0; i<m; i++){
            if(grid[i][0] == 'O' && !vis[i][0]){
                dfs(grid, vis, i, 0);
            }
        }

        // bottom boundary
        for(int j=0; j<n; j++){
            if(grid[m-1][j] == 'O' && !vis[m-1][j]){
                dfs(grid, vis, m-1, j);
            }
        }

        // right boundary
        for(int i=0; i<m; i++){
            if(grid[i][n-1] == 'O' && !vis[i][n-1]){
                dfs(grid, vis, i, n-1);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 'O' && !vis[i][j]){
                    grid[i][j] = 'X';
                }
            }
        }
    }
    
    public static void main(String args[]){
        char grid[][] = {   {'X','X','X','X','X'},
                            {'X','O','O','X','O'},
                            {'X','X','O','X','O'}, 
                            {'X','O','X','O','X'},
                            {'O','O','X','X','X'}
                        };

        updateMatrix(grid);

        for(char arr[]: grid){
            for(char c: arr){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
