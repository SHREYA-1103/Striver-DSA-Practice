import java.util.*;

public class VerticalTraversal {
    
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

        public Info(Node n, int h){
            this.node = n;
            this.hd = h;
        }
    }

    public static void verticalTraversal(Node root){
        if(root == null) return;

        HashMap<Integer, List<Node>> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();

        int min = 0, max = 0;

        q.add(new Info(root, 0));

        while(!q.isEmpty()){
            Info top = q.remove();

            min = Math.min(min, top.hd);
            max = Math.max(max, top.hd);

            if(map.containsKey(top.hd)){
                List<Node> l = map.get(top.hd);
                l.add(top.node);
            }
            else{
                List<Node> l = new ArrayList<>();
                l.add(top.node);
                map.put(top.hd, l);
            }

            if(top.node.left != null) q.add(new Info(top.node.left, top.hd-1));
            if(top.node.right != null) q.add(new Info(top.node.right, top.hd+1));
        }

        for(int i=min; i<=max; i++){
            for(Node n: map.get(i)){
                System.out.print(n.data + " ");
            }
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

        verticalTraversal(root);
    }
}
