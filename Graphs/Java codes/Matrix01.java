// Given a 2D grid, for each cell in the grid, find the distance to the nearest 1

import java.util.*;

public class Matrix01 {

    public static class Pair {
        int row;
        int col;
        int dist;

        public Pair(int r, int c, int d) {
            this.row = r;
            this.col = c;
            this.dist = d;
        }
    }

    // For each cell, find distance to the nearest 1
    public static int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        // Initialize:
        // - All cells with 1 → distance 0, add to queue
        // - All cells with 0 → distance INF for now
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        // Directions: up, down, left, right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        // Multi-source BFS
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;
            int d = p.dist;

            for (int k = 0; k < 4; k++) {
                int nr = r + dRow[k];
                int nc = c + dCol[k];

                // Check valid cell
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    dist[nr][nc] = d + 1;
                    q.add(new Pair(nr, nc, d + 1));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 0, 1}
        };

        int[][] res = updateMatrix(grid);

        for (int[] arr : res) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
