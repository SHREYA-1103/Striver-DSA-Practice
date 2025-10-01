import java.util.*;

public class TreeTraversals {
    
    public static class Node{
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
        Node node;
        boolean flag;

        public Info(Node n, boolean f){
            this.node = n;
            this.flag = f;
        }
    }

    public static class Pair{
        Node node;
        int num;

        public Pair(Node n, int num){
            this.node = n;
            this.num = num;
        }
    }

    // optimal - O(n), O(n)
    public static void inorder_rec(Node root){
        if(root == null) return;

        inorder_rec(root.left);
        System.out.print(root.data + " ");
        inorder_rec(root.right);
    }

    // optimal - O(n), O(n)
    public static void inorder_iter(Node root){
        if(root == null) return;

        Stack<Info> s = new Stack<>();

        s.push(new Info(root, false));

        while(!s.isEmpty()){
            Info top = s.pop();
            if(top.flag) System.out.print(top.node.data + " ");
            else{
                top.flag = true;
                if(top.node.right != null) s.push(new Info(top.node.right, false));
                s.push(top);
                if(top.node.left != null) s.push(new Info(top.node.left, false));
            }
        }
    }

    // optimal - O(n), O(n)
    public static void preorder_rec(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preorder_rec(root.left);
        preorder_rec(root.right);
    }

    // optimal - O(n), O(n)
    public static void preorder_iter(Node root){
        if(root == null) return;

        Stack<Node> s = new Stack<>();

        s.push(root);

        while(!s.isEmpty()){
            Node top = s.pop();
            System.out.print(top.data + " ");
            if(top.right != null) s.push(top.right);
            if(top.left != null) s.push(top.left);
        }
    }

    // optimal - O(n), O(n)
    public static void postorder_rec(Node root){
        if(root == null) return;

        postorder_rec(root.left);
        postorder_rec(root.right);
        System.out.print(root.data + " ");
    }

    // optimal - O(n), O(n)
    public static void postorder_iter(Node root){ // using 1 stack
        if(root == null) return;

        Stack<Info> s = new Stack<>();

        s.push(new Info(root, false));

        while(!s.isEmpty()){
            Info top = s.pop();
            if(top.flag) System.out.print(top.node.data + " ");
            else{
                top.flag = true;
                s.push(top);
                if(top.node.right != null) s.push(new Info(top.node.right, false));
                if(top.node.left != null) s.push(new Info(top.node.left, false));
            }
        }
    }

    // optimal - O(n), O(2n)
    public static void postorder_iter2(Node root){ // using 2 stacks
        if(root == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            Node top = s1.pop();
            s2.push(top);
            if(top.left != null) s1.push(top.left);
            if(top.right != null) s1.push(top.right);
        }

        while(!s2.isEmpty()){
            System.out.print(s2.pop().data + " ");
        }
    }

    // optimal - O(n), O(n)
    public static void levelorder(Node root){
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            Node top = q.remove();
            System.out.print(top.data + " ");
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }
    }

    // optimal - O(n), O(n)
    public static void preInPost(Node root){
        if(root == null) return;

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair> s = new Stack<>();

        s.push(new Pair(root, 1));

        while(!s.isEmpty()){
            Pair curr = s.pop();
            switch (curr.num) {
                case 1 -> {
                    preorder.add(curr.node.data);
                    s.push(new Pair(curr.node, curr.num+1));
                    if(curr.node.left != null) s.push(new Pair(curr.node.left, 1));
                }
                case 2 -> {
                    inorder.add(curr.node.data);
                    s.push(new Pair(curr.node, curr.num+1));
                    if(curr.node.right != null) s.push(new Pair(curr.node.right, 1));
                }
                case 3 -> postorder.add(curr.node.data);
                default -> {
                }
            }
        }
    
        System.out.print("  Preorder: ");
        for(int val: preorder) System.out.print(val + " ");
        System.out.println();
            
        System.out.print("  Inorder: ");
        for(int val: inorder) System.out.print(val + " ");
        System.out.println();
        
        System.out.print("  Postorder: ");
        for(int val: postorder) System.out.print(val + " ");
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("Inorder recursive: ");
        inorder_rec(root);
        System.out.println();

        System.out.print("Inorder iterative: ");
        inorder_iter(root);
        System.out.println();

        System.out.print("Preorder recursive: ");
        preorder_rec(root);
        System.out.println();

        System.out.print("Preorder iterative: ");
        preorder_iter(root);
        System.out.println();

        System.out.print("Postorder recursive: ");
        postorder_rec(root);
        System.out.println();

        System.out.print("Postorder iterative: ");
        postorder_iter(root);
        System.out.println();
        
        System.out.print("Postorder iterative (using 2 stacks): ");
        postorder_iter2(root);
        System.out.println();

        System.out.print("Level order: ");
        levelorder(root);
        System.out.println(); 

        System.out.println("PreInPost order: ");
        preInPost(root);
        System.out.println(); 
    }
}
