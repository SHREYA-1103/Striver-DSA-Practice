// Given a graph, find the count of connected components which exist in it. A connected component is a subgraph where each node is reachable from every other node.

import java.util.*;

public class CountConnectedComponents {

    // O(V+E), O(V)
    public static int countProvinces(int n, List<List<Integer>> graph){
        Stack<Integer> s = new Stack<>();

        boolean vis[] = new boolean[n];

        int count = 0;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                count++;
                vis[i] = true;
                s.add(i);
                
                while(!s.isEmpty()){
                    int node = s.pop();
                    for(int v: graph.get(node)){
                        if(!vis[v]){
                            vis[v] = true;
                            s.push(v);
                        }
                    }
                }
            }
        }

        return count;
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

        System.out.println(countProvinces(n, graph));
    }
}
