// Given a graph, find if there exists a cycle in the graph, using both bfs and dfs.

import java.util.*;

public class CycleDetection {

    public static class Pair{
        int node;
        int parent;

        public Pair(int n, int p){
            this.node = n;
            this.parent = p;
        }
    }

    // O(V+E), O(V)
    public static boolean bfs(int n, List<List<Integer>> graph){
        Queue<Pair> q = new LinkedList<>();

        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                vis[i] = true;
                q.add(new Pair(i, -1));

                while(!q.isEmpty()){
                    Pair p = q.remove();
                    int node = p.node;
                    int par = p.parent;
                    for(int v: graph.get(node)){
                        if(!vis[v]){
                            vis[v] = true;
                            q.add(new Pair(v, node));
                        }
                        else if(par != v) return true;
                    }
                }
            }
        }

        return false;
    }

    // O(V+E), O(V)
    public static boolean dfs(int n, List<List<Integer>> graph){
        Stack<Pair> s = new Stack<>();

        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                vis[i] = true;
                s.add(new Pair(i, -1));

                while(!s.isEmpty()){
                    Pair p = s.pop();
                    int node = p.node;
                    int par = p.parent;
                    for(int v: graph.get(node)){
                        if(!vis[v]){
                            vis[v] = true;
                            s.push(new Pair(v, node));
                        }
                        else if(par != v) return true;
                    }
                }
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

        System.out.println(bfs(n, graph));

        System.out.println(dfs(n, graph));
    }
}
