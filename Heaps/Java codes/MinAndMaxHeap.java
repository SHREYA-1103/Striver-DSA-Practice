import java.util.*;

public class MinAndMaxHeap {

    // Min-heap implementation
    public static void topDownHeapify_min(ArrayList<Integer> arr, int idx){
        int left = 2*idx + 1;
        int right = 2*idx + 2;

        int minIdx = idx;

        if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
            minIdx = left;
        }
        if(right < arr.size() && arr.get(right) < arr.get(minIdx)){
            minIdx = right;
        }

        if(minIdx != idx){
            int temp = arr.get(idx);
            arr.set(idx, arr.get(minIdx));
            arr.set(minIdx, temp);

            topDownHeapify_min(arr, minIdx);
        }
    }
    
    // Max-heap implementation
    public static void topDownHeapify_max(ArrayList<Integer> arr, int idx){
        int left = 2*idx + 1;
        int right = 2*idx + 2;

        int maxIdx = idx;

        if(left < arr.size() && arr.get(left) > arr.get(maxIdx)){
            maxIdx = left;
        }
        if(right < arr.size() && arr.get(right) > arr.get(maxIdx)){
            maxIdx = right;
        }

        if(maxIdx != idx){
            int temp = arr.get(idx);
            arr.set(idx, arr.get(maxIdx));
            arr.set(maxIdx, temp);

            topDownHeapify_max(arr, maxIdx);
        }
    }

    public static void buildMinHeap(ArrayList<Integer> arr) {
        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            topDownHeapify_min(arr, i);
        }
    }

    public static void buildMaxHeap(ArrayList<Integer> arr) {
        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            topDownHeapify_max(arr, i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 4, 6, 3, 2));

        buildMinHeap(arr);

        System.out.println(arr);

        buildMaxHeap(arr);

        System.out.println(arr);
    }
}
