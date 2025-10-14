public class LCAInBST {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static int findLCA(Node root, int n1, int n2){
        while (root != null) {
            if (n1 < root.data && n2 < root.data) {
                root = root.left;
            }
            else if (n1 > root.data && n2 > root.data) {
                root = root.right;
            } 
            else {
                return root.data;
            }
        }
        return -1;
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
        int n1 = 2;
        int n2 = 3;

        Node root = buildBST(arr);

        System.out.println(findLCA(root, n1, n2));
    }
}
