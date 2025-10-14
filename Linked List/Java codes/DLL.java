
public class DLL {
    
    public static class DLLNode{
        int data;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int val){
            this.data = val;
        }
    }

    public static DLLNode insertFirst(DLLNode head, int val){
        DLLNode newNode = new DLLNode(val);
        
        if(head == null){
            head = newNode;
            return head;
        }

        newNode.next = head;
        head.prev = newNode;

        head = newNode;

        return head;
    }

    public static DLLNode insertLast(DLLNode head, int val){
        DLLNode newNode = new DLLNode(val);

        if(head == null){
            return newNode;
        }

        DLLNode temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }


    public static DLLNode insertMid(DLLNode head, int val, int idx){
        DLLNode newNode = new DLLNode(val);
        
        if(head == null){
            if(idx == 0) head = newNode;
            return head;
        }

        DLLNode temp = head;
        int count = 0;
        
        while(temp != null && count < idx-1){
            count++;
            temp = temp.next;
        }

        if(temp == null) return head;
        
        DLLNode dummy = temp.next;
    
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = dummy;

        if(dummy != null) dummy.prev = newNode;

        return head;
    }

    public static DLLNode deleteFirst(DLLNode head){
        if(head == null || head.next == null) return null;
 
        head = head.next;
        head.prev = null;

        return head;
    }

    public static DLLNode deleteLast(DLLNode head){
        if(head == null || head.next == null) return null;

        DLLNode temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        DLLNode prev = temp.prev;
        prev.next = null;
        temp.next = null;

        return head;
    }

    public static DLLNode deleteMid(DLLNode head, int idx){
        if(head == null) return null; // no element in the LL or first node is to be deleted

        if(idx == 0){
            head = head.next;
            if(head != null) head.prev = null;
            return head;
        }
        
        DLLNode temp = head;
        int count = 0;

        while(temp != null && count < idx){
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Index out of bounds.");
            return head;
        }

        DLLNode prev = temp.prev;
        DLLNode next = temp.next;

        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;

        return head;
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

        System.out.println("DLL before insertion: ");
        printDLL(head); // 1 2 3
        System.out.println();
        
        head = insertFirst(head, 5); // 5 1 2 3
        head = insertLast(head, 4); // 5 1 2 3 4
        head = insertMid(head, 5, 2); // 5 1 5 2 3 4

        System.out.println("DLL after insertions and before deletions: ");
        printDLL(head);
        System.out.println();

        head = deleteFirst(head); // 1 5 2 3 4
        head = deleteLast(head); // 1 5 2 3
        head = deleteMid(head, 2); // 1 5 3 

        System.out.println("DLL after deleteion: ");
        printDLL(head);
        System.out.println();
    }
}
