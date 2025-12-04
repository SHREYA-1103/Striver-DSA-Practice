import java.util.*;

public class CourseAllocation {

    public static List<Integer> order;
    
    public static void dfs(int node, boolean vis[], Stack<Integer> s, List<List<Integer>> graph){
        vis[node] = true;

        for(int v: graph.get(node)){
            if(!vis[v]){
                dfs(v, vis, s, graph);
            }
        }

        s.push(node);
    }

    public static boolean canCompleteAll(List<List<Integer>> graph){
        int n = graph.size();
        
        Stack<Integer> s = new Stack<>();

        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, vis, s, graph);
            }
        }

        order = new ArrayList<>();

        while(!s.isEmpty()){
            order.add(s.pop());
        }

        return order.size() == n;
    }

    public static List<List<Integer>> buildGraph(int n, int courses[][]){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int course[]: courses){
            graph.get(course[0]).add(course[1]);
        }

        return graph;
    }
    
    public static void main(String args[]){
        int n = 4;
        int courses[][] = {{1,0}, {2,1}, {3,2}};

        List<List<Integer>> graph = buildGraph(n, courses);

        System.out.println(canCompleteAll(graph));
        System.out.println(order);
    }
}
