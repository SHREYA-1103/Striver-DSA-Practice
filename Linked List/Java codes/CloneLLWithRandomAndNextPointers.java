public class CloneLLWithRandomAndNextPointers {
    
    public static class Node{
        int data;
        Node next;
        Node random;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static void printLL(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        temp = head;

        while(temp != null){
            System.out.print(temp.random == null ? "null " : temp.random.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Optimal - O(3n), O(1)
    public static Node cloneLL(Node head){
        Node temp = head;

        // create copy nodes and place them in between the original nodes of the LL
        while(temp != null){
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // update the random pointers for every node
        temp = head;

        while(temp != null){
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }

        // update the next pointers of the new LL
        temp = head;

        Node dNode = new Node(-1);

        Node res = dNode;

        while(temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
            res.next = null;
        }

        return dNode.next;
    }

    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.random = head.next;
        head.random = head.next.next;

        printLL(head);

        Node head1 = cloneLL(head);

        printLL(head1);
    }
}
