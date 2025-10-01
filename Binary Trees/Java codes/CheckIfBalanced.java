public class CheckIfBalanced {

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

    // bruteforce - O(n^2), O(n)
    public static boolean isBalanced_brute(Node root){
        if(root == null) return true;

        int leftHt = calcHeight(root.left);
        int rightHt = calcHeight(root.right);

        if(Math.abs(leftHt - rightHt) > 1) return false;

        return isBalanced_brute(root.left) && isBalanced_brute(root.right);
    }

    public static int calcHeight(Node root){
        if(root == null) return 0;

        int leftHt = calcHeight(root.left);
        int rightHt = calcHeight(root.right);

        return Math.max(leftHt, rightHt)+1;
    }

    // optimal - O(n), O(n)
    public static int isBalanced_optimal(Node root){
        if(root == null) {
            return 0;
        }

        int leftHt = isBalanced_optimal(root.left);
        int rightHt = isBalanced_optimal(root.right);

        if(leftHt == -1 || rightHt == -1 || Math.abs(leftHt - rightHt) > 1) return -1;

        return Math.max(leftHt, rightHt)+1;
    }
    
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left.left = new Node(5);

        System.out.println(isBalanced_brute(root));
        System.out.println(isBalanced_optimal(root) == -1 ? "false" : "true");
    }
}
