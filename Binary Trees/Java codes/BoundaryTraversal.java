import java.util.*;

public class BoundaryTraversal {

    public static class Node {
        int data;
        Node left, right;

        public Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // optimal - O(n), O(n)
    public static void boundaryTraversal(Node root) {
        if (root == null) return;

        if (!(root.left == null && root.right == null)) {
            System.out.print(root.data + " ");
        }

        printLeftBoundary(root.left);

        printLeaves(root);

        printRightBoundary(root.right);
    }

    // Print left boundary nodes excluding leaves
    public static void printLeftBoundary(Node node) {
        while (node != null) {
            if (!(node.left == null && node.right == null)) { // not a leaf node
                System.out.print(node.data + " ");
            }
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    // Print leaf nodes
    public static void printLeaves(Node node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }
        printLeaves(node.left);
        printLeaves(node.right);
    }

    // Print right boundary nodes excluding leaves, in reverse
    private static void printRightBoundary(Node node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!(node.left == null && node.right == null)) { // not a leaf node
                stack.push(node.data);
            }
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(7);
        root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(6);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);

        boundaryTraversal(root);
    }
}
