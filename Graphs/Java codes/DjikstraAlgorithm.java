import java.util.*;

public class DjikstraAlgorithm {

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }
    
    // O(E log V), O(V)
    public static int[] shortestDistances(List<List<int []>> graph, int src){
        int n = graph.size();

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int u = p.node;
            int d = p.dist;

            for(int e[]: graph.get(u)){
                int v = e[0];
                int wt = e[1];
                if(d + wt < dist[v]){
                    dist[v] = d+wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String args[]){
        List<List<int[]>> graph = new ArrayList<>();
        int n = 6;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new int[] {1, 4});
        graph.get(0).add(new int[] {2, 4});
        graph.get(1).add(new int[] {2, 2});
        graph.get(2).add(new int[] {3, 3});
        graph.get(2).add(new int[] {5, 6});
        graph.get(2).add(new int[] {4, 1});
        graph.get(3).add(new int[] {5, 2});
        graph.get(4).add(new int[] {5, 3});
        graph.get(1).add(new int[] {0, 4});
        graph.get(2).add(new int[] {0, 4});
        graph.get(2).add(new int[] {1, 2});
        graph.get(3).add(new int[] {2, 3});
        graph.get(5).add(new int[] {2, 6});
        graph.get(4).add(new int[] {2, 1});
        graph.get(5).add(new int[] {3, 2});
        graph.get(5).add(new int[] {4, 3});

        int src = 0;

        int dist[] = shortestDistances(graph, src);

        for(int d: dist){
            System.out.print((d == Integer.MAX_VALUE ? -1 : d) + " ");
        }
    }
}
