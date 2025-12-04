import java.util.*;

public class EventualSafeState {
    
    public static boolean dfs(int node, int state[], Stack<Integer> s, List<List<Integer>> graph, List<Integer> safeStates){
        if(state[node] != 0) return state[node] == 2;
        
        state[node] = 1; // visiting

        for(int v: graph.get(node)){
            if(!dfs(v, state, s, graph, safeStates)) return false;
        }

        state[node] = 2; // safe

        return true;
    }

    public static List<Integer> getSafeStates(List<List<Integer>> graph){
        int n = graph.size();
        
        Stack<Integer> s = new Stack<>();

        int[] state = new int[n]; // 0=unvisited, 1=visiting, 2=safe

        List<Integer> safeStates = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(dfs(i, state, s, graph, safeStates)) safeStates.add(i);
        }

        Collections.sort(safeStates);

        return safeStates;
    }

    public static void main(String args[]){
        List<List<Integer>> graph = new ArrayList<>();
        int n = 10;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(4).add(5);
        graph.get(5).add(6);
        graph.get(6).add(4);
        graph.get(7).add(1);
        graph.get(7).add(8);
        graph.get(8).add(9);

        System.out.println(getSafeStates(graph));
    }
}
