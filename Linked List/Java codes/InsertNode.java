
public class InsertNode {

    public static class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
        }
    }

    public static void printLL(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node insertFirst(Node head, int val){
        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;

        return head;
    }

    public static Node insertLast(Node head, int val){
        if(head == null) return insertFirst(head, val);
        
        Node newNode = new Node(val);

        if(head.next == null){
            head.next = newNode;
            return head;
        }

        Node temp = head;
        Node prev = null;

        while(temp != null){
            prev = temp;
            temp = temp.next;
        }

        prev.next = newNode;

        return head;
    }

    public static Node insertMid(Node head, int val, int idx){
        Node newNode = new Node(val);

        if (idx == 0 || head == null) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;

        int count = 0;

        while (temp != null && count < idx - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
    
    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println("LL before insertion: ");
        printLL(head); // 1 2 3
        System.out.println();
        
        head = insertFirst(head, 5); // 5 1 2 3
        head = insertLast(head, 4); // 5 1 2 3 4
        head = insertMid(head, 5, 2); // 5 1 5 2 3 4

        System.out.println("LL after insertions: ");
        printLL(head);
        System.out.println();
    }
}
