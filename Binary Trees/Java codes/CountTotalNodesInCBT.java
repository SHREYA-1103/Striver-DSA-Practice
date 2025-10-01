public class CountTotalNodesInCBT {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static int findLeftHeight(Node root){
        if(root == null) return 0;

        return 1+findLeftHeight(root.left);
    }

    public static int findRightHeight(Node root){
        if(root == null) return 0;

        return 1+findRightHeight(root.right);
    }

    public static int countNodes(Node root){
        if(root == null) return 0;

        int leftHt = findLeftHeight(root);
        int rightHt = findRightHeight(root);

        if(leftHt == rightHt) return (int)Math.pow(2,leftHt)-1;

        return countNodes(root.left)+countNodes(root.right)+1;
    }
    
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println(countNodes(root));
    }
}
