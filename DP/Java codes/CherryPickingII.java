// ------------------------------ Ques ----------------------------------
// Given a rectangular grid, of size m*n, that is, a grid with m rows and n columns in each row. Assume Alice is standing at the tp left corner (0,0) and Bob at the top right corner (0, n-1). In every step, they can move to either i-1 or i or i+1 index in the (j+1)th row. Find the max path sum that ALice and Bob can together take, starting from the first row to any index in the last row. If one person has already crossed a cell, it cannot be recounted in the other person's path.
// ----------------------------------------------------------------------


public class CherryPickingII {

    // O(m*n^2), O(m*n^2)
    public static int maxPathsSum_tab(int grid[][]){
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int i = 0; i < m; i++)
            for (int j1 = 0; j1 < n; j1++)
                for (int j2 = 0; j2 < n; j2++)
                    dp[i][j1][j2] = Integer.MIN_VALUE;

        dp[0][0][n - 1] = grid[0][0] + (n - 1 == 0 ? 0 : grid[0][n - 1]);

        for (int i = 1; i < m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int maxPrev = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int pj1 = j1 - dj1;
                            int pj2 = j2 - dj2;
                            if (pj1 >= 0 && pj1 < n && pj2 >= 0 && pj2 < n) {
                                maxPrev = Math.max(maxPrev, dp[i - 1][pj1][pj2]);
                            }
                        }
                    }
                    if (maxPrev != Integer.MIN_VALUE) {
                        int val = grid[i][j1];
                        if (j1 != j2) val += grid[i][j2];
                        dp[i][j1][j2] = val + maxPrev;
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                ans = Math.max(ans, dp[m - 1][j1][j2]);
            }
        }

        return ans;
    }


    // O(m*n^2), O(n^2)
    public static int maxPathsSum_so(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] next = new int[n][n];
        int[][] curr = new int[n][n];

        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == 0 && j2 == n - 1)
                    next[j1][j2] = grid[0][0] + (j1 != j2 ? grid[0][n - 1] : 0);
                else
                    next[j1][j2] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int maxPrev = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int pj1 = j1 - dj1;
                            int pj2 = j2 - dj2;
                            if (pj1 >= 0 && pj1 < n && pj2 >= 0 && pj2 < n) {
                                maxPrev = Math.max(maxPrev, next[pj1][pj2]);
                            }
                        }
                    }
                    if (maxPrev != Integer.MIN_VALUE) {
                        int val = grid[i][j1];
                        if (j1 != j2) val += grid[i][j2];
                        curr[j1][j2] = val + maxPrev;
                    } else {
                        curr[j1][j2] = Integer.MIN_VALUE;
                    }
                }
            }
            for (int j1 = 0; j1 < n; j1++)
                System.arraycopy(curr[j1], 0, next[j1], 0, n);
        }

        int ans = Integer.MIN_VALUE;
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                ans = Math.max(ans, next[j1][j2]);
            }
        }

        return ans;
    }
    
    public static void main(String args[]){
        int[][] grid = {
            {3, 1, 1},
            {2, 5, 1},
            {1, 5, 5},
            {2, 1, 1}
        };

        System.out.println(maxPathsSum_tab(grid));

        System.out.println(maxPathsSum_so(grid));
    }
}
