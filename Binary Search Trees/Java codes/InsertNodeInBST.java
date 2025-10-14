public class InsertNodeInBST {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static Node buildBST(int arr[]){
        Node root = null;
        
        for (int i = 0; i < arr.length; i++) {
            root = insert(arr[i], root);
        }

        return root;
    }

    public static Node insert(int val, Node root) {
        if(root == null){
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(val, root.left);
        } 
        else {
            root.right = insert(val, root.right);
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
        int val = 6;

        Node root = buildBST(arr);
        System.out.println("Tree before insertion: ");
        printTree(root);
        System.out.println();

        System.out.println("Tree after insertion: ");
        printTree(insert(val, root));
        System.out.println();
    }
}
