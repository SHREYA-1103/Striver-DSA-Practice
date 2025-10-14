public class ValidateBST {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static boolean isBSTHelper(Node root, int min, int max){
        if(root == null) return true;
        
        if(root.data > max || root.data < min) return false;

        return isBSTHelper(root.left, min, root.data) && isBSTHelper(root.right, root.data, max);
    }

    public static boolean isBST(Node root){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return isBSTHelper(root, min, max);
    }
    
    public static void main(String args[]){
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(15);
        root.left.left = new Node(6);
        root.right.left = new Node(17);

        System.out.println(isBST(root));
    }
}
