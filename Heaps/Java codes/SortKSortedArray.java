import java.util.*;

public class SortKSortedArray {
    
    public static void nearlySorted(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<Integer> pq =  new PriorityQueue<>(); // min heap

        // Push first k elements in pq - one of them will definitely be the first element of the sorted array
        for (int i = 0; i < k; i++) 
            pq.add(arr[i]);

        int i;
        for (i = k; i < n; i++) {
            pq.add(arr[i]);
            arr[i - k] = pq.poll();
        }

        // Put remaining elements in array
        while (!pq.isEmpty()) {
            arr[i - k] = pq.poll();
            i++;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {6, 5, 3, 2, 8, 10, 9};

        nearlySorted(arr, k);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}