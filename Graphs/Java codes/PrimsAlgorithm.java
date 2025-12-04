import java.util.*;

public class PrimsAlgorithm {

    public static List<List<Integer>> mst(List<List<int []>> graph){
        List<List<Integer>> mst = new ArrayList<>();

        int n = graph.size();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, 0, -1});

        boolean vis[] = new boolean[n];

        int sum = 0;

        while(!pq.isEmpty()){
            int info[] = pq.remove();

            int wt = info[0];
            int node = info[1];
            int parent = info[2];

            if(!vis[node]){
                sum+=wt;
                vis[node] = true;
                if(parent != -1){
                    List<Integer> l = new ArrayList<>();
                    l.add(parent);
                    l.add(node);
                    mst.add(l);
                }

                for(int edge[] : graph.get(node)){
                    int v = edge[0];

                    if(!vis[v]){
                        pq.add(new int[] {edge[1], v, node});
                    }
                }
            }
        }

        return mst;
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

        List<List<Integer>> mstEdges = mst(graph);

        System.out.println(mstEdges);
    }
}
