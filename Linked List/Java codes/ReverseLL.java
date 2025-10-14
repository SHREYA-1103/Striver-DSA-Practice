public class ReverseLL {

    public static class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
        }
    }

    public static Node reverseLL(Node head){
        Node temp = head;

        if(head == null) return null;

        Node prev = null, next;

        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    public static void printLL(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println("LL before reversal: ");
        printLL(head); // 1 2 3
        System.out.println();

        head = reverseLL(head);

        System.out.println("LL after reversal: ");
        printLL(head);
        System.out.println();
    }

    
}
