public class ConstructBSTFromPreorder {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    static int idx;

    public static Node buildBST(int arr[]){
        idx = 0;
        Node root = buildBSTHelper(arr, Integer.MAX_VALUE);

        return root;
    }

    public static Node buildBSTHelper(int arr[], int ub) {
        if(idx == arr.length || arr[idx] > ub) return null;

        Node root = new Node(arr[idx++]);

        root.left = buildBSTHelper(arr, root.data);
        root.right = buildBSTHelper(arr, ub);

        return root;
    }

    public static void printTree(Node root){
        if(root == null) return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }
    
    public static void main(String args[]){
        int preorder[] = {8,5,1,7,10,12};

        Node root = buildBST(preorder);

        printTree(root);
    }
}
