public class RecoverBST {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static void swap(Node root, int n1, int n2) {
        if (root == null) return;

        // Find the nodes
        Node[] nodes = new Node[2];
        findNodes(root, n1, n2, nodes);

        // Swap if both found
        if (nodes[0] != null && nodes[1] != null) {
            int temp = nodes[0].data;
            nodes[0].data = nodes[1].data;
            nodes[1].data = temp;
        }
    }

    public static void findNodes(Node root, int n1, int n2, Node[] nodes) {
        if (root == null) return;

        if (root.data == n1) nodes[0] = root;
        if (root.data == n2) nodes[1] = root;

        if (nodes[0] != null && nodes[1] != null) return;

        findNodes(root.left, n1, n2, nodes);
        findNodes(root.right, n1, n2, nodes);
    }

    static Node first, prev, middle, last;

    public static void inorder(Node root){
        if(root == null) return;

        inorder(root.left);

        if(prev != null && (root.data < prev.data)){ 
            if(first == null){ // first interchange
                first = prev;
                middle = root;
            }
            else last = root;
        }

        prev = root;
        inorder(root.right);
    }
    
    public static void recoverBST(Node root){
        first = middle = last = null;

        prev = new Node(Integer.MIN_VALUE);

        inorder(root);

        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if(first != null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
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

        Node root = buildBST(arr);

        System.out.println("Tree before swap: ");
        printTree(root);
        System.out.println();

        int n1 = 3;
        int n2 = 7;
        swap(root, n1, n2);

        System.out.println("Tree after swap: ");
        printTree(root);
        System.out.println();

        recoverBST(root);

        System.out.println("Tree after correction: ");
        printTree(root);
        System.out.println();
    }
}
