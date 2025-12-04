import java.util.*;

public class PathWithMinEffort {

    public static int minEfforts(int heights[][]){
        int m = heights.length;
        int n = heights[0].length;

        int dist[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[] {0, 0, 0});

        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};

        while(!pq.isEmpty()){
            int info[] = pq.remove();

            int effort = info[0];
            int row = info[1];
            int col = info[2];

            if(row == m-1 && col == n-1) return effort;

            for(int i=0; i<4; i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[nr][nc]));
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.add(new int[] {newEffort, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
    
    public static void main(String args[]){
        int heights[][] = {{1,2,2}, {3,8,2}, {5,3,5}};

        System.out.println(minEfforts(heights));
    }
}
