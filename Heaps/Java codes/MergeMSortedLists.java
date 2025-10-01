import java.util.*;

public class MergeMSortedLists {
    public static class Node implements Comparable<Node>{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
            this.next = null;
        }

        @Override
        public int compareTo(Node n2){
            return this.data - n2.data; // ascending order
        }
    }

    public static Node mergeLists(List<Node> heads){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(Node node : heads){
            if(node != null){
                pq.add(node);
            }
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        while(!pq.isEmpty()){
            Node curr = pq.remove();
            tail.next = curr;
            tail = tail.next;

            if(curr.next != null){
                pq.add(curr.next);
            }
        }

        return dummy.next;
    }

    public static void main(String args[]){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(10);
        head2.next.next = new Node(11);

        Node head3 = new Node(2);
        head3.next = new Node(4);
        head3.next.next = new Node(6);

        List<Node> heads = new ArrayList<>();
        heads.add(head1);
        heads.add(head2);
        heads.add(head3);

        Node head = mergeLists(heads);

        Node temp = head;
        
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
