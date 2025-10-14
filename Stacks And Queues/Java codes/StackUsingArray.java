public class StackUsingArray {

    public static class Stack{
        int arr[];
        int idx;
        int size;

        public Stack(int n){
            arr = new int[n];
            idx = -1;
            size = n;
        }

        public void push(int val){
            if(isFull()){
                System.out.println("Stack is full");
                return;
            }
            
            arr[++idx] = val;
        } 

        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }

            int res = arr[idx];
            
            idx--;
            
            return res;
        }

        public boolean isFull(){
            return idx == size-1;
        }

        public boolean isEmpty(){
            return idx == -1;
        }

        public int top(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            
            return arr[idx];
        }
    }
    
    public static void main(String args[]){
        Stack s = new Stack(5);

        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        s.push(5);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}
