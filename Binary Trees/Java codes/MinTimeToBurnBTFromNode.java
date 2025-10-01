import java.util.*;

public class MinTimeToBurnBTFromNode {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static int minTime(Node root, Node target) {        
        if(root == null) return 0;

        HashMap<Node, Node> map = new HashMap<>();
        map.put(root, null);

        HashSet<Node> vis = new HashSet<>();

        getParent(root, map);

        Queue<Node> q = new LinkedList<>();
        q.add(target);
        vis.add(target);

        int time = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean burned = false;

            for(int i=0; i<size; i++){
                Node curr = q.remove();
                if(curr.left != null && !vis.contains(curr.left)){
                    q.add(curr.left);
                    vis.add(curr.left);
                    burned = true;
                }
                if(curr.right != null && !vis.contains(curr.right)){
                    q.add(curr.right);
                    vis.add(curr.right);
                    burned = true;
                }
                Node par = map.get(curr);
                if(par != null && !vis.contains(par)){
                    q.add(map.get(curr));
                    vis.add(par);
                    burned = true;
                }
            }

            if(burned) time++;
        }

        return time;
    }

    public static void getParent(Node root, HashMap<Node, Node> map){
        if(root == null) return;

        if(root.left != null) map.put(root.left, root);
        if(root.right != null) map.put(root.right, root);

        getParent(root.left, map);
        getParent(root.right, map);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        Node target = root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(7);
        root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(6);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);

        System.out.println(minTime(root, target));
    }
}
