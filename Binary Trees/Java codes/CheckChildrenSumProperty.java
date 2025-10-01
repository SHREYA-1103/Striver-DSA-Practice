public class CheckChildrenSumProperty {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static void changeTree(Node root){
        if(root == null) return;

        int childSum = 0;

        if(root.left != null) childSum += root.left.data;
        if(root.right != null) childSum += root.right.data;

        if(childSum >= root.data){
            root.data = childSum;
        }

        else{
            if(root.left != null) root.left.data = root.data;
            if(root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int totalSum = 0;

        if(root.left != null) totalSum += root.left.data;
        if(root.right != null) totalSum += root.right.data;

        if(root.left != null || root.right != null){
            root.data = totalSum;
        }
    }

    public static void printTree(Node root){
        if(root == null) return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(7);
        root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(6);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);

        printTree(root);
        System.out.println();

        changeTree(root);

        printTree(root);
        System.out.println();
    }
}
