import java.util.*;

public class PathFromRootToNode {
    
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

    public static void printPath(Node root, Node target){
        if(root == null || target == null) return;

        ArrayList<Node> path = new ArrayList<>();

        path.add(root);

        if(pathHelper(root, target, path)){
            for(Node n: path){
                System.out.print(n.data + " ");
            }
        }

        else System.out.print("No path exists");        
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

    public static void main(String args[]){
        Node root = new Node(1);
        Node target = root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(7);
        root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(6);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);

        printPath(root, target);
    }
}
