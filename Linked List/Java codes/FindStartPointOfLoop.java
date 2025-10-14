public class FindStartPointOfLoop {

    public static class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
        }
    }

    public static Node hasLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return slow;
        }

        return null;
    }

    public static Node findStart(Node head, Node meetNode){
        Node slow = head;
        Node fast = meetNode;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    
    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;

        Node node = hasLoop(head); // if loop exists - node = meeting point of slow and fast, else null

        if(node != null){
            System.out.println(findStart(head, node).data);
        }
        else{
            System.out.println("Loop does not exist");
        }
    }

    
}
