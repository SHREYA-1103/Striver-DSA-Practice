// Given an inorder and a postorder traversal sequence of a  binary tree, to print the level order traversal of the binary tree so formed

import java.util.*;

public class ConstructBTFromInorderPostorder {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            this.left = this.right = null;
        }
    }

    static int postIdx;
    
    // O(n), O(n)
    public static Node buildTree(int postorder[], int inorder[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        postIdx = postorder.length-1;

        return buildTreeHelper(postorder, map, 0, postorder.length-1);
    }

    // O(n), O(n)
    public static Node buildTreeHelper(int postorder[], HashMap<Integer, Integer> map, int start, int end){
        if(start > end) return null;

        Node root = new Node(postorder[postIdx--]); 

        int inIdx = map.get(root.data);

        root.right = buildTreeHelper(postorder, map, inIdx+1, end);
        root.left = buildTreeHelper(postorder, map, start, inIdx-1);
        
        return root;
    }

    // O(n), O(n)
    public static void printTree(Node root){
        if(root == null) return;
        
        List<String> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.remove();
            
            if(curr != null){
                res.add(Integer.toString(curr.data));
                q.add(curr.left);
                q.add(curr.right);
            }

            else{
                res.add("null");
            }
        }

        int idx = res.size()-1;

        while(idx >= 0 && res.get(idx).equals("null")){
            res.remove(idx);
            idx--;
        }

        System.out.println(res);
    }

    public static void main(String args[]){
        int inorder[] = {2,1,4,3,5};
        int postorder[] = {2,4,5,3,1};

        Node root = buildTree(postorder, inorder);

        printTree(root);
    }
}
