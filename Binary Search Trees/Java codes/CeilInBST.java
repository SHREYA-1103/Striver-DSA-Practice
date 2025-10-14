public class CeilInBST {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static int findCeil(Node root, int key){
        int ceil = -1;

        while(root != null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }

            if(root.data < key){
                root = root.right;
            }
            else{
                ceil = root.data;
                root = root.left;
            }
        }

        return ceil;
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
        int key = 4;

        Node root = buildBST(arr);

        System.out.println(findCeil(root, key));
    }
}
