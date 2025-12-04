import java.util.*;

public class CycleDetectionDirectedGraph {

    public static boolean dfsUtil(List<List<Integer>> graph, boolean vis[], boolean pathVis[], int node){
        vis[node] = true;
        pathVis[node] = true;

        for(int v: graph.get(node)){
            if(!vis[v]){
                if(dfsUtil(graph, vis, pathVis, v)) return true;
            }
            else if(pathVis[v]) return true;
        }

        pathVis[node] = false;
        return false;
    }
    
    // O(V+E), O(V)
    public static boolean dfs(int n, List<List<Integer>> graph){
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(dfsUtil(graph, vis, pathVis, i)) return true;
            }
        }

        return false;
    }

    public static void main(String args[]){
        int n = 6; // no. of nodes in the graph
        List<List<Integer>> graph = new ArrayList<>(); // graph as an adjacency list

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(2);
        graph.get(2).add(4);
        graph.get(1).add(3);
        graph.get(4).add(3);
        graph.get(3).add(5);

        System.out.println(dfs(n, graph));
    }
}
