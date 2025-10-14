public class QueueUsingArray {

    public static class Queue {
        int arr[];
        int front;
        int rear;
        int size;

        public Queue(int n) {
            arr = new int[n];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void add(int val) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            rear = (rear + 1) % arr.length;
            arr[rear] = val;
            size++;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int res = arr[front];
            front = (front + 1) % arr.length;
            size--;
            return res;
        }

        public boolean isFull() {
            return size == arr.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);

        q.add(2); // 2
        q.add(3); // 2 3
        System.out.println(q.remove()); // 2
        q.add(5); // 3 5
        System.out.println(q.peek()); // 3
        System.out.println(q.remove()); // 3
        System.out.println(q.peek()); // 5
    }
}
