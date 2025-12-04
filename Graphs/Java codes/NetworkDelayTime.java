import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());

        for (int[] it : times) {
            adj.get(it[0]).add(new int[] {it[1], it[2]});
        }

        // dist[node] = minimum time needed to reach node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, k});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int time = info[0];
            int node = info[1];

            for (int[] edge : adj.get(node)) {
                int v = edge[0];
                int wt = edge[1];

                if (dist[v] > time + wt) {
                    dist[v] = time + wt;
                    pq.add(new int[] {dist[v], v});
                }
            }
        }

        int maxTime = 0;
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
    
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }
}
