
public class IsSymmetric {
    
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

    public static boolean isSymmetric(Node root){
        return root == null || symmetricHelper(root.left, root.right);
    }

    public static boolean symmetricHelper(Node left, Node right){        
        if(left == null || right == null) return left == right;
        
        if(left.data != right.data) return false;

        return symmetricHelper(left.left, right.right) && symmetricHelper(left.right, right.left);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(isSymmetric(root));
    }
}
