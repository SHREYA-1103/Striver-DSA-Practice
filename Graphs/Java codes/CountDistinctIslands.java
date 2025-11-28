// given a grid of binary values, with 0 representing the sea and 1 representing the land, find the count of distinct islands, that is unique islands (piece of one of more connected 1's). Two islands are assumed to be the same only if they have identical shapes.

import java.util.*;

public class CountDistinctIslands {

    public static void dfs(int matrix[][], boolean vis[][], List<String> list, int row, int col, int br, int bc){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 0 || vis[row][col]) return;
        
        vis[row][col] = true;

        list.add("#"+(row-br)+"#"+(col-bc));
        
        dfs(matrix, vis, list, row, col+1, br, bc);
        dfs(matrix, vis, list, row+1, col+1, br, bc);
        dfs(matrix, vis, list, row+1, col, br, bc);
        dfs(matrix, vis, list, row+1, col-1, br, bc);
    }

    // O(n^2), O(n^2)
    public static int numIslands(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;

        boolean vis[][] = new boolean[m][n];

        Set<List<String>> set = new HashSet<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1 && !vis[i][j]){
                    List<String> list = new ArrayList<>();
                    dfs(matrix, vis, list, i, j, i, j);
                    set.add(list);
                }
            }
        }

        return set.size();
    }
    
    public static void main(String args[]){
        int matrix[][] = {
            {1,1,0,1,1}, 
            {1,0,0,0,0}, 
            {0,0,0,1,1}, 
            {1,1,0,1,0}
        };

        System.out.println(numIslands(matrix));
    }
}

