public class HeightOfTree {

    public static class Node{
        @SuppressWarnings("unused")
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // optimal - O(n), O(n)
    public static int calcHeight(Node root){
        if(root == null) return 0;

        int leftHt = calcHeight(root.left);
        int rightHt = calcHeight(root.right);

        return Math.max(leftHt, rightHt)+1;
    }
    
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left.left = new Node(5);

        System.out.println("Height of the tree: " + calcHeight(root));
    }
}
