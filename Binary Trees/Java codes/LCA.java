import java.util.*;

public class LCA {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // bruteforce - O(2n), O(4n)
    public static int findLCA_brute(Node root, Node n1, Node n2){
        if(root == null || n1 == null || n2 == null) return -1;

        ArrayList<Node> path1 = new ArrayList<>();
        path1.add(root);
        pathHelper(root, n1, path1);

        ArrayList<Node> path2 = new ArrayList<>();
        path2.add(root);
        pathHelper(root, n2, path2);

        int lca = -1;

        for(int i=0; i<Math.min(path1.size(), path2.size()); i++){
            if(path1.get(i) == path2.get(i)) lca = path1.get(i).data;
        }

        return lca;  
    }

    public static boolean pathHelper(Node root, Node target, List<Node> path){
        if(root == null) return false;
        
        if(root == target) return true;
        
        // look for target in the left subtree
        if(root.left != null){
            path.add(root.left);
            boolean leftPath = pathHelper(root.left, target, path);
            if(leftPath) return true;
            else{
                path.remove(path.size()-1);
            }
        }
        // look for target in the right subtree
        if(root.right != null){
            path.add(root.right);
            boolean rightPath = pathHelper(root.right, target, path);
            if(rightPath) return true;
            else path.remove(path.size()-1);
        }

        return false;
    }

    // optimal - O(n), O(n)
    public static int findLCA_optimal(Node root, Node n1, Node n2){
        if(root == null) return -1;

        if(root == n1) return n1.data;

        if(root == n2) return n2.data;

        int left = findLCA_optimal(root.left, n1, n2);
        int right = findLCA_optimal(root.right, n1, n2);

        if(left == n1.data && right == n2.data) return root.data;

        if(left == -1) return right;

        else return left;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        Node n1 = root.right.left = new Node(4);
        root.right.right = new Node(7);
        Node n2 = root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(6);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);

        System.out.println(findLCA_brute(root, n1, n2));
        System.out.println(findLCA_optimal(root, n1, n2));
    }
}
