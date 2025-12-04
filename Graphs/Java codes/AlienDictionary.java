import java.util.*;

public class AlienDictionary {

    public static void dfs(int node, boolean vis[], Stack<Integer> s, List<List<Integer>> graph){
        vis[node] = true;

        for(int v: graph.get(node)){
            if(!vis[v]){
                dfs(v, vis, s, graph);
            }
        }

        s.push(node);
    }

    public static List<Character> topoSort(List<List<Integer>> graph){
        int n = graph.size();
        
        Stack<Integer> s = new Stack<>();

        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, vis, s, graph);
            }
        }

        List<Character> order = new ArrayList<>();

        while(!s.isEmpty()){
            order.add((char)(s.pop()+'a'));
        }

        return order;
    }

    public static List<List<Integer>> buildGraph(int n, String words[]){
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<words.length-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int j=0; j<len; j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1 != c2){
                    int u = c1-'a';
                    int v = c2-'a';
                    graph.get(u).add(v);
                    break;
                }
            }
        }

        return graph;
    }
    
    public static void main(String args[]){
        int n = 4; // characters in alien dictionary
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};

        List<List<Integer>> graph = buildGraph(n, words);

        System.out.println(topoSort(graph));
    }
}
