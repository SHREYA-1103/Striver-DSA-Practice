public class KthElementInBST {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    static int count = 0;

    public static int kthSmallestHelper(Node root, int k, int count) {
        if (root == null) return -1;

        // Search left
        int left = kthSmallestHelper(root.left, k, count);
        if (left != -1) return left;

        count++;
        if (count == k) return root.data;

        // Search right
        return kthSmallestHelper(root.right, k, count);
    }

    public static int findKthSmallest(Node root, int k) {
        count = 0;
        return kthSmallestHelper(root, k, count);
    }

    public static int kthLargestHelper(Node root, int k, int count) {
        if (root == null) return -1;

        // Search right
        int right = kthLargestHelper(root.right, k, count);
        if (right != -1) return right;

        count++;
        if (count == k) return root.data;

        // Search left
        return kthLargestHelper(root.left, k, count);
    }

    public static int findKthLargest(Node root, int k){
        count = 0;
        return kthLargestHelper(root, k, count);
    }

    public static Node buildBST(int arr[]){
        Node root = null;
        
        for (int i = 0; i < arr.length; i++) {
            root = buildBSTHelper(arr[i], root);
        }

        return root;
    }

    public static Node buildBSTHelper(int val, Node root) {
        if(root == null){
            return new Node(val);
        }
        if (val < root.data) {
            root.left = buildBSTHelper(val, root.left);
        } 
        else {
            root.right = buildBSTHelper(val, root.right);
        }
        return root;
    }
    
    public static void main(String args[]){
        int arr[] = {1,3,5,2,10,7,9};
        int k = 2;

        Node root = buildBST(arr);

        System.out.println(findKthSmallest(root, k));

        System.out.println(findKthLargest(root, k));
    }
}
