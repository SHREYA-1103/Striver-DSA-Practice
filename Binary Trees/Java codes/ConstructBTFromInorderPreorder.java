// given the inorder and preorder traversal sequences of a binary tree, to construct a binary tree from the same and print its level order traversal

import java.util.*;

public class ConstructBTFromInorderPreorder {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            this.left = this.right = null;
        }
    }

    static int preIdx;
    
    // O(n), O(n)
    public static Node buildTree(int preorder[], int inorder[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, map, 0, preorder.length-1);
    }

    // O(n), O(n)
    public static Node buildTreeHelper(int preorder[], HashMap<Integer, Integer> map, int start, int end){
        if(start > end) return null;

        Node root = new Node(preorder[preIdx++]); 

        int inIdx = map.get(root.data);

        root.left = buildTreeHelper(preorder, map, start, inIdx-1);
        root.right = buildTreeHelper(preorder, map, inIdx+1, end);
        
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
        int preorder[] = {4,1,2,3,5};

        Node root = buildTree(preorder, inorder);

        printTree(root);
    }
}

