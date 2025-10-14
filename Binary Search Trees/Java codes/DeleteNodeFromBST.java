public class DeleteNodeFromBST {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static Node deleteNode(Node root, int val){
        if(root == null){
            return null;
        }

        if(root.data == val){
            return deleteHelper(root);
        }

        Node dummy = root;

        while(root != null){
            if(root.data > val){
                if(root.left != null && root.left.data == val){
                    root.left = deleteHelper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.data == val){
                    root.right = deleteHelper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }

        return dummy;
    }

    public static Node deleteHelper(Node root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    public static Node findLastRight(Node root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
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
        int node = 10;

        Node root = buildBST(arr);

        System.out.println("Tree before deletion: ");
        printTree(root);
        System.out.println();

        System.out.println("Tree after deletion: ");
        printTree(deleteNode(root, node));
        System.out.println();
    }
}
