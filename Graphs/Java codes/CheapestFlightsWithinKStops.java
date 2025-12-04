import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] {f[1], f[2]});
        }

        // dist[node] = min cost to reach node with <= current stops
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Queue stores: {stops, node, cost}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, src, 0});

        while (!q.isEmpty()) {
            int[] info = q.remove();
            int stops = info[0];
            int node = info[1];
            int cost = info[2];

            if (stops > k) continue;

            for (int[] edge : adj.get(node)) {
                int v = edge[0];
                int wt = edge[1];

                if (dist[v] > cost + wt) {
                    dist[v] = cost + wt;
                    q.add(new int[] {stops + 1, v, dist[v]});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
    
    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}
