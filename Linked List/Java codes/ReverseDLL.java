public class ReverseDLL {

    public static class DLLNode{
        int data;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int val){
            this.data = val;
        }
    }

    public static DLLNode reverseDLL(DLLNode head){
        DLLNode temp = head;

        if(head == null) return null;

        DLLNode last = null;

        while(temp != null){
            last = temp.prev;
            temp.prev = temp.next;
            temp.next = last;
            temp = temp.prev;
        }

        return last.prev;
    }

    public static void printDLL(DLLNode head){
        DLLNode temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    public static void main(String args[]){
        DLLNode head = new DLLNode(1);
        head.next = new DLLNode(2);
        head.next.prev = head;
        head.next.next = new DLLNode(3);
        head.next.next.prev = head.next;

        System.out.println("DLL before reversal: ");
        printDLL(head); // 1 2 3
        System.out.println();

        head = reverseDLL(head);

        System.out.println("DLL after reversal: ");
        printDLL(head);
        System.out.println();
    }

    
}
