// Connected components in a matrix
// Given a 2D matrix with binary values in each of the cells. ) implies water, whereas 1 implies land area. All the neighboring 1's. that is the ones that can be reached from a cell with values=1 (movement allowed in all 8 directions) forms an iland. Find the min number of islands formed in the given matrix.

public class CountIslands {

    public static void dfs(int matrix[][], boolean vis[][], int row, int col){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 0 || vis[row][col]) return;
        
        vis[row][col] = true;
        
        dfs(matrix, vis, row, col+1);
        dfs(matrix, vis, row+1, col+1);
        dfs(matrix, vis, row+1, col);
        dfs(matrix, vis, row+1, col-1);
    }

    // O(n^2), O(n^2)
    public static int numIslands(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;

        boolean vis[][] = new boolean[m][n];

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1 && !vis[i][j]){
                    count++;
                    vis[i][j] = true;
                    dfs(matrix, vis, i, j);
                }
            }
        }

        return count;
    }
    
    public static void main(String args[]){
        int matrix[][] = {{0,1,1,0}, {0,1,1,0}, {0,0,1,0}, {0,0,0,0}, {1,1,0,1}};

        System.out.println(numIslands(matrix));
    }
}
