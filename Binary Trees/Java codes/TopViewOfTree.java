import java.util.*;

public class TopViewOfTree {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            this.left = this.right = null;
        }
    }

    public static class Info{
        Node node;
        int hd;

        public Info(Node n, int hd){
            this.node = n;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        if(root == null) return;

        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0;
        int max = 0;

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(root, 0));

        while(!q.isEmpty()){
            Info top = q.remove();
            min = Math.min(min, top.hd);
            max = Math.max(max, top.hd);
            if(!map.containsKey(top.hd)) map.put(top.hd, top.node);
            if(top.node.left != null) q.add(new Info(top.node.left, top.hd-1));
            if(top.node.right != null) q.add(new Info(top.node.right, top.hd+1));
        }

        for(int i=min; i<=max; i++){
            if(map.containsKey(i)) System.out.print(map.get(i).data + " ");
        }
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

        topView(root);
    }
}
