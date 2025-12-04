import java.util.*;

public class ShortestPathDAG {
    
    public static void dfs(int node, boolean vis[], Stack<Integer> s, List<List<int[]>> graph){
        vis[node] = true;

        for(int p[]: graph.get(node)){
            int v = p[0];
            if(!vis[v]){
                dfs(v, vis, s, graph);
            }
        }

        s.push(node);
    }

    public static int[] minDist(List<List<int[]>> graph, int src){
        int n = graph.size();
        
        Stack<Integer> s = new Stack<>();

        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, vis, s, graph);
            }
        }

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!s.isEmpty()){
            int node = s.pop();
            int d = dist[node];
            for(int p[]: graph.get(node)){
                int v = p[0];
                int wt = p[1];
                dist[v] = Math.min(dist[v], d+wt);
            }   
        }

        return dist;
    }

    public static void main(String args[]){
        List<List<int[]>> graph = new ArrayList<>();
        int n = 7;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new int[] {1,2});
        graph.get(1).add(new int[] {3,1});
        graph.get(2).add(new int[] {3,3});
        graph.get(4).add(new int[] {0,3});
        graph.get(4).add(new int[] {2,1});
        graph.get(5).add(new int[] {4,1});
        graph.get(6).add(new int[] {4,2});
        graph.get(6).add(new int[] {5,3});

        int src = 6;

        int dist[] = minDist(graph, src);

        for(int d: dist){
            System.out.print(d + " ");
        }
    }
}
