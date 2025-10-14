public class InorderPredecessorSuccessor {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static int InorderPred(Node root, int node){
        int res = -1;
        
        while (root != null) {
            if (node > root.data) {
                res = root.data;
                root = root.right;
            }
            else if (node <= root.data) {
                root = root.left;
            }
        }
        return res;
    }
    
    public static int InorderSucc(Node root, int node){
        int res = -1;
        
        while (root != null) {
            if (node >= root.data) {
                root = root.right;
            }
            else if (node < root.data) {
                res = root.data;
                root = root.left;
            }
        }
        return res;
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
        int node = 5;

        Node root = buildBST(arr);

        System.out.println(InorderPred(root, node));
        
        System.out.println(InorderSucc(root, node));
    }
}
