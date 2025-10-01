public class DiameterOfTree {

    public static class Node{
        @SuppressWarnings("unused")
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class Info{
        int diam;
        int ht;

        public Info(int d, int h){
            this.diam = d;
            this.ht = h;
        }
    }

    // bruteforce - O(n^2), O(n)
    public static int calcDiameter_brute(Node root){
        if(root == null) return 0;

        int leftDiam = calcDiameter_brute(root.left);
        int rightDiam = calcDiameter_brute(root.right);

        int leftHt = calcHeight(root.left);
        int rightHt = calcHeight(root.right);

        return Math.max(leftHt+rightHt+1, Math.max(leftDiam, rightDiam));
    }

    public static int calcHeight(Node root){
        if(root == null) return 0;

        int leftHt = calcHeight(root.left);
        int rightHt = calcHeight(root.right);

        return Math.max(leftHt, rightHt)+1;
    }

    // optimal - O(n), O(n)
    public static Info calcDiameter_optimal(Node root){
        if(root == null) return new Info(0,0);

        Info leftInfo = calcDiameter_optimal(root.left);
        Info rightInfo = calcDiameter_optimal(root.right);

        int diam = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.diam, rightInfo.diam));
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
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

        System.out.println("Diameter of the tree: " + calcDiameter_brute(root));
        System.out.println("Diameter of the tree: " + calcDiameter_optimal(root).diam);
    }
}
