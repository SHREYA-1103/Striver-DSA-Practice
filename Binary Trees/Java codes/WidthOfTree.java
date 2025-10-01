import java.util.*;

public class WidthOfTree {
    
    public static class Node{
        @SuppressWarnings("unused")
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class Pair{
        Node node;
        int idx;

        public Pair(Node n, int i){
            this.node = n;
            this.idx = i;
        }
    }

    public static int calcWidth(Node root){
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        int start = 0;
        int end = 0;

        int ans = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            Pair first = q.peek(); // first node of every level
            int minIdx = first.idx; // min index for the current level;
            for(int i=0; i<size; i++){ // process nodes for each level one by one
                Pair curr = q.remove();
                int idx = curr.idx - minIdx;
                Node node = curr.node;
                if(i == 0) start = idx;
                if(i == size-1) end = idx;
                if(node.left != null){
                    q.add(new Pair(node.left, 2*idx+1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, 2*idx+2));
                }
            }
            ans = Math.max(ans, end-start+1);
        }

        return ans;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(7);
        root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(6);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);

        System.out.println("Width of the tree: " + calcWidth(root));
    }
}
