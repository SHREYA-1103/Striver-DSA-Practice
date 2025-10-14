public class DeleteNode {

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

    public static Node deleteFirst(Node head){
        head = head.next;

        return head;
    }

    public static Node deleteLast(Node head){
        if(head == null || head.next == null) return null;

        Node temp = head;
        Node prev = null;

        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;

        return head;
    }

    public static Node deleteMid(Node head, int idx){
        if(head == null || idx == 0) return null; // no element in the LL or first node is to be deleted

        Node temp = head;
        Node prev = null;
        int count = 0;

        while(temp != null){
            if(count == idx){
                prev.next = temp.next;
                return head;
            }

            count++;
            
            prev = temp;
            temp = temp.next;
        }

        return head;
    }
    
    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("LL before deletions: ");
        printLL(head); // 1 2 3 4
        System.out.println();
        
        head = deleteFirst(head); // 2 3 4
        head = deleteLast(head); // 2 3
        int idx = 2;
        head = deleteMid(head, idx); // 2 3 - no element at idx 2

        System.out.println("LL after deletions: ");
        printLL(head);
        System.out.println();
    }
}
