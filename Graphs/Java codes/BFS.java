// Given a graph, to traverse all its nodes using BFS traversal, that is level-wise traversal.

import java.util.*;

public class BFS {

    // O(V+E), O(V)
    public static void bfs(int n, List<List<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();

        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                vis[i] = true;
                q.add(i);
            }
            while(!q.isEmpty()){
                int node = q.remove();
                System.out.print(node + " ");
                for(int v: graph.get(node)){
                    if(!vis[v]){
                        vis[v] = true;
                        q.add(v);
                    }
                }
            }
        }
    }
    
    public static void main(String args[]){
        int n = 6; // no. of nodes in the graph
        List<List<Integer>> graph = new ArrayList<>(); // graph as an adjacency list

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1); // acyclic directed unweighted graph - assumed 0-based indexing
        graph.get(0).add(2);
        graph.get(1).add(2);
        graph.get(2).add(4);
        graph.get(1).add(3);
        graph.get(4).add(3);
        graph.get(3).add(5);

        bfs(n, graph);
    }
}
