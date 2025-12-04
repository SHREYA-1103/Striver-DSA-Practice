import java.util.*;

public class TopologicalSort {

    public static void dfs(int node, boolean vis[], Stack<Integer> s, List<List<Integer>> graph){
        vis[node] = true;

        for(int v: graph.get(node)){
            if(!vis[v]){
                dfs(v, vis, s, graph);
            }
        }

        s.push(node);
    }

    public static List<Integer> topoSort(List<List<Integer>> graph){
        int n = graph.size();
        
        Stack<Integer> s = new Stack<>();

        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, vis, s, graph);
            }
        }

        List<Integer> order = new ArrayList<>();

        while(!s.isEmpty()){
            order.add(s.pop());
        }

        return order;
    }
    
    public static void main(String args[]){
        List<List<Integer>> graph = new ArrayList<>();
        int n = 4;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(0);
        graph.get(2).add(0);
        graph.get(3).add(0);

        System.out.println(topoSort(graph));
    }
}
