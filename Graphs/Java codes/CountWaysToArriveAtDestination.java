import java.util.*;

public class CountWaysToArriveAtDestination {

    public static int MOD = (int)1e9 + 7;

    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]}); 
        }

        // dist[node] = shortest time to reach node
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        // ways[node] = number of shortest ways to reach node
        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] info = pq.poll();
            long time = info[0];
            int node = (int)info[1];

            for (int[] edge : adj.get(node)) {
                int v = edge[0];
                int wt  = edge[1];

                if (dist[v] > time + wt) {
                    dist[v] = time + wt;
                    ways[v] = ways[node];
                    pq.add(new long[]{dist[v], v});

                } else if (dist[v] == time + wt) {
                    ways[v] = (ways[v] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                {0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},
                {3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}
        };

        System.out.println(countPaths(n, roads));
    }
}
