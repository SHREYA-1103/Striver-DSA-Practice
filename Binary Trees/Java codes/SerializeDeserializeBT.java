import java.util.*;

public class SerializeDeserializeBT {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
        }
    }

    public static void serializeBT(Node root, List<String> serial){
        if(root == null){
            serial.add("null");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.remove();

            if(curr == null){
                serial.add("null");
            }
            else{
                serial.add(Integer.toString(curr.data));
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        // remove trailing "null"s
        int i = serial.size() - 1;
        while(i >= 0 && serial.get(i).equals("null")){
            serial.remove(i);
            i--;
        }
    }

    static int idx;
    
    public static Node deserializeBT(List<String> serial){
        if(serial == null || idx > serial.size()-1) return null;

        Node root = new Node(Integer.parseInt(serial.get(0)));

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty() && idx < serial.size()){
            Node curr = q.remove();

            // left child
            if(!serial.get(idx).equals("null")){
                curr.left =new Node(Integer.parseInt(serial.get(idx)));
                q.add(curr.left);
            }
            idx++;

            if(idx >= serial.size()) break;

            // right child
            if(!serial.get(idx).equals("null")){
                curr.right =new Node(Integer.parseInt(serial.get(idx)));
                q.add(curr.right);
            }
            idx++;
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        printTree(root);
        System.out.println();

        List<String> serial = new ArrayList<>();
        serializeBT(root, serial);
        System.out.println(serial);

        printTree(deserializeBT(serial));

    }
}
