public class MorrisTraversals {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static void morrisPreorder(Node root){
        if(root == null) return;

        Node curr = root;

        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else{
                Node prev = curr.left;

                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    System.out.print(curr.data + " ");
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void morrisInorder(Node root){
        Node curr = root;

        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        morrisPreorder(root);
        System.out.println();

        morrisInorder(root);
    }
}
