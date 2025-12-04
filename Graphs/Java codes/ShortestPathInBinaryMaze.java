import java.util.*;

public class ShortestPathInBinaryMaze {

    public static int minPathLength(int grid[][], int src[], int dest[]){
        int m = grid.length;
        int n = grid[0].length;

        int dist[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[src[0]][src[1]] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, src[0], src[1]});

        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};

        while(!q.isEmpty()){
            int info[] = q.remove();

            int d = info[0];
            int row = info[1];
            int col = info[2];

            for(int i=0; i<4; i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && dist[nr][nc] > d+1){
                    dist[nr][nc] = d+1;
                    q.add(new int[] {d+1, nr, nc});
                }
            }
        }

        return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1:dist[dest[0]][dest[1]];

    }
    
    public static void main(String args[]){
        int grid[][] = {{1,1,1,1}, {1,1,0,1}, {1,1,1,1}, {1,1,0,0}, {1,0,0,0}};
        int src[] = {0,1};
        int dest[] = {2,2};

        System.out.println(minPathLength(grid, src, dest));
    }
}
