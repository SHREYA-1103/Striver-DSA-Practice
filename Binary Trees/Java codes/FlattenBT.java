import java.util.*;

public class FlattenBT {

    static Node prev = null;
    
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void flatten(Node root){
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void printTree(Node root){
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        List<String> result = new ArrayList<>();

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(curr.val));
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        // remove trailing "null"s
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i--);
        }

        System.out.println(result);
    }
    
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        flatten(root);

        printTree(root);
    }
}
