import java.util.*;

public class KthLargestElementInStream {

    public static class Solution{
        static PriorityQueue<Integer> pq;
        static int k;

        void kthLargest(int k, int arr[]){
            pq = new PriorityQueue<>(k);
            Solution.k = k;

            int n = arr.length;
            
            for(int i=0; i<n; i++){
                add(arr[i]);
            }
        }

        int add(int num){
            if(pq.size() < k){
                pq.add(num);
            }
            else if(num > pq.peek()){
                pq.remove();
                pq.add(num);
            }

            return pq.size() < k ? -1 : pq.peek();
        }
    }
    
    public static void main(String args[]){
        Solution sol = new Solution();

        sol.kthLargest(2, new int[] {5,5,5,5});
        System.out.println(sol.add(2));
        System.out.println(sol.add(6));
        System.out.println(sol.add(60));
    }
}
