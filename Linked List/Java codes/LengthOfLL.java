public class LengthOfLL {
    
    public static class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
        }
    }

    public static int lengthOfLL(Node head){
        Node temp = head;

        int len = 0;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }

        return len;
    }

    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println(lengthOfLL(head));
    }
}
