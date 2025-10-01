import java.util.*;

public class RightViewOfTree {
    
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
        int level;

        public Info(Node n, int lev){
            this.node = n;
            this.level = lev;
        }
    }

    public static void rightView(Node root){
        if(root == null) return;

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(root, 0));

        int prevLevel = -1;
        int lastNode = -1;

        while(!q.isEmpty()){
            Info top = q.remove();
            if(top.level != prevLevel){
                if(lastNode != -1) System.out.print(lastNode + " ");
                lastNode = top.node.data;
                prevLevel = top.level;
            }
            else{
                lastNode = top.node.data;
            }
            if(top.node.left != null) q.add(new Info(top.node.left, top.level+1));
            if(top.node.right != null) q.add(new Info(top.node.right, top.level+1));
        }

        System.out.print(lastNode);
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

        rightView(root);
    }
}
