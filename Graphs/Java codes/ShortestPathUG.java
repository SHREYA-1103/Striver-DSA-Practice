import java.util.*;

public class ShortestPathUG {

    public static int[] minDistance(List<List<Integer>> graph, int src){
        int n = graph.size();

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int u = q.remove();
            int d = dist[u];

            for(int v: graph.get(u)){
                if(d + 1 < dist[v]){
                    dist[v] = d+1;
                    q.add(v);
                }
            }
        }

        return dist;
    }
    
    public static void main(String args[]){
        List<List<Integer>> graph = new ArrayList<>();
        int n = 9;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(3);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(6);
        graph.get(3).add(0);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(4);
        graph.get(5).add(6);
        graph.get(6).add(2);
        graph.get(6).add(5);
        graph.get(6).add(7);
        graph.get(6).add(8);
        graph.get(7).add(6);
        graph.get(7).add(8);
        graph.get(8).add(6);
        graph.get(8).add(7);

        int src = 0;

        int dist[] = minDistance(graph, src);

        for(int d: dist){
            System.out.print((d == Integer.MAX_VALUE ? -1 : d) + " ");
        }
    }
}
