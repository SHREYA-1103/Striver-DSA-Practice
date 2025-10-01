import java.util.*;

public class MedianFromStream {

    public static class MedianFinder{
        static PriorityQueue<Integer> left;   // max-heap
        static PriorityQueue<Integer> right;  // min-heap

        public MedianFinder(){
            left = new PriorityQueue<>(Collections.reverseOrder()); // smaller half
            right = new PriorityQueue<>();                          // larger half
        }

        public void add(int num){
            // add to left (maxHeap)
            if(left.isEmpty() || num <= left.peek()){
                left.add(num);
            } else {
                right.add(num);
            }

            // balance heaps (sizes differ by at most 1)
            if(left.size() > right.size() + 1){
                right.add(left.remove());
            }
            else if(right.size() > left.size()){
                left.add(right.remove());
            }
        }

        public double findMedian(){
            if(left.size() == right.size()){
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }
    
    public static void main(String args[]){
        MedianFinder mf = new MedianFinder();

        mf.add(1);
        mf.add(6);
        System.out.println(mf.findMedian()); // 3.5
        mf.add(3);
        System.out.println(mf.findMedian()); // 3.0
        mf.add(5);
        System.out.println(mf.findMedian()); // 4.0
        mf.add(2);
        System.out.println(mf.findMedian()); // 3.0
    }
}
