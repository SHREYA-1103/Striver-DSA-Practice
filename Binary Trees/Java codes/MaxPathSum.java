public class MaxPathSum {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            this.left = this.right = null;
        }
    }

    static int maxSum;

    public static int maxPathSum(Node root){
        if(root == null) return 0;

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        int currMax = left + right + root.data;

        maxSum = Math.max(maxSum, currMax);

        return Math.max(left, right) + root.data;
    }

    public static void main(String args[]){
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        maxPathSum(root);

        System.out.println(maxSum);
    }
}
