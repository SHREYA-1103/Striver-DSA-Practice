import java.util.*;

public class BipartiteGraph {

    // linear graphs with no cycle or graphs with even length cycle are bipartite graphs
    // O(n+e), O(n)
    public static boolean isBipartite_bfs(List<List<Integer>> graph){
        int n = graph.size();

        int color[] = new int[n];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;

                while(!q.isEmpty()){
                    int node = q.remove();
                    for(int v: graph.get(node)){
                        if(color[v] == -1){
                            color[v] = 1-color[node];
                            q.add(v);
                        }
                        else if(color[v] == color[node]) return false;
                    }
                }
            }
        }

        return true;
    }

    // O(n+e), O(n)
    public static boolean isBipartite_dfs(List<List<Integer>> graph){
        int n = graph.size();

        int color[] = new int[n];
        Arrays.fill(color, -1);

        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                s.push(i);
                color[i] = 0;

                while(!s.isEmpty()){
                    int node = s.pop();
                    for(int v: graph.get(node)){
                        if(color[v] == -1){
                            color[v] = 1-color[node];
                            s.push(v);
                        }
                        else if(color[v] == color[node]) return false;
                    }
                }
            }
        }

        return true;
    }
    
    public static void main(String args[]){
        List<List<Integer>> graph = new ArrayList<>();
        int n = 8;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(1).add(5);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(3).add(6);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(4);
        graph.get(5).add(1);
        graph.get(6).add(3);
        graph.get(6).add(7);
        graph.get(7).add(6);

        System.out.println(isBipartite_bfs(graph));

        System.out.println(isBipartite_dfs(graph));
    }
}
