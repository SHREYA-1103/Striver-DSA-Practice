public class SearchInLL {
    
    public static class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
        }
    }

    public static boolean searchLL(Node head, int key){
        Node temp = head;
        
        while(temp != null){
            if(temp.data == key) return true;
            temp = temp.next;
        }

        return false;
    }

    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        int key = 4;

        System.out.println(searchLL(head, key));
    }
}
