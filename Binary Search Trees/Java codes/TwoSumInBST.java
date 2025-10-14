public class TwoSumInBST {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static boolean sumExists(Node root, int sum){
        
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

    public static void printTree(Node root){
        if(root == null) return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }
    
    public static void main(String args[]){
        int arr[] = {1,3,5,2,10,7,9};
        int sum = 10;

        Node root = buildBST(arr);

        System.out.println(sumExists(root, sum));
    }
}
