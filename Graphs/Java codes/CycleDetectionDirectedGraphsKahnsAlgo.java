import java.util.*;

public class CycleDetectionDirectedGraphsKahnsAlgo {

    // kahns algo for topological sort - indegree based approach
    public static boolean hasCycle(List<List<Integer>> graph){
        int n = graph.size();

        Queue<Integer> q = new LinkedList<>();

        int indegree[] = new int[n];

        for(int i=0; i<n; i++){
            for(int v: graph.get(i)){
                indegree[v]++;
            }
        }

        for(int i=0; i<n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.remove();
            res.add(node);
            for(int v: graph.get(node)){
                indegree[v]--;
                if(indegree[v] == 0) q.add(v);
            }
        }

        return res.size() != n; // valid top sort means no cycle
    }
    
    public static void main(String args[]){
        List<List<Integer>> graph = new ArrayList<>();
        int n = 4;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(1);

        System.out.println(hasCycle(graph));
    }
}
