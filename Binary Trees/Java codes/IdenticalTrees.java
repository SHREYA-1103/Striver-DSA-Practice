public class IdenticalTrees {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static boolean isIdentical(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null) return false;

        if(root1.data != root2.data) return false;

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.right.left = new Node(6);

        System.out.println(isIdentical(root, root1));
    }
}
