// Given a 2D matrix where each cell contains an integer color, perform a flood fill starting from a given source cell. Replace the color of the source cell and all its 4-directionally connected cells (up, down, left, right) that have the same original color with a new color. Return or print the updated matrix.

public class FloodFill {

    public static void dfs(int matrix[][], int row, int col, int newColor, int oldColor){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] != oldColor || matrix[row][col] == newColor) return;
        
        matrix[row][col] = newColor;
        
        dfs(matrix, row, col-1, newColor, oldColor);
        dfs(matrix, row-1, col, newColor, oldColor);
        dfs(matrix, row, col+1, newColor, oldColor);
        dfs(matrix, row+1, col, newColor, oldColor);
    }

    // O(n^2), O(n^2)
    public static void fillColor(int matrix[][], int srcRow, int srcCol, int color){
        dfs(matrix, srcRow, srcCol, color, matrix[srcRow][srcCol]);
    }
    
    public static void main(String args[]){
        int matrix[][] = {{0,1,1,0}, {0,1,1,0}, {0,0,1,0}, {0,0,0,0}, {1,1,0,1}};
        int srcRow = 1;
        int srcCol = 1;
        int color = 2;

        fillColor(matrix, srcRow, srcCol, color);

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
