import java.util.*;

public class KthElementInArray {

    public static int getKthLargest(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: arr){
            pq.add(num);
            if(pq.size() > k) pq.remove();
        }

        return pq.peek();
    }

    public static int getKthSmallest(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num: arr){
            pq.add(num);
            if(pq.size() > k) pq.remove();
        }

        return pq.peek();
    }
    
    public static void main(String args[]){
        int arr[] = {-5,4,1,2,-3};
        int k = 5;

        System.out.println(getKthSmallest(arr, k));

        System.out.println(getKthLargest(arr, k));
    }
}
