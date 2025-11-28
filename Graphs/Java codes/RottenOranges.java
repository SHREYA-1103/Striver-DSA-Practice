// Given a 2D matrix where each cell contains an integer color, perform a flood fill starting from a given source cell. Replace the color of the source cell and all its 4-directionally connected cells (up, down, left, right) that have the same original color with a new color. Return or print the updated matrix.

import java.util.*;

public class RottenOranges {

    public static class Pair{
        int row, col, time;

        public Pair(int i, int j, int t){
            this.row = i;
            this.col = j;
            this.time = t;
        }
    }

    // O(n^2), O(n^2)
    public static int minTime(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<Pair> q = new LinkedList<>();

        int vis[][] = new int[m][n];

        int countFresh = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(matrix[i][j] == 1) countFresh++;
            }
        }

        int time = 0;
        int dirRow[] = {-1,0,1,0};
        int dirCol[] = {0,1,0,-1};

        int count = 0;

        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int t = p.time;
            time = Math.max(time, t);
            for(int i=0; i<4; i++){
                int nRow = row + dirRow[i];
                int nCol = col + dirCol[i];
                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && matrix[nRow][nCol] == 1){
                    q.add(new Pair(nRow, nCol, t+1));
                    vis[nRow][nCol] = 2;
                    count++;
                }
            }
        }

        return count == countFresh ? time : -1;
    }
    
    public static void main(String args[]){
        int oranges[][] = {{0,1,2}, {0,1,1}, {2,1,1}};

        System.out.println(minTime(oranges));
    }
}
