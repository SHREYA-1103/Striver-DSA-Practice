
import java.util.Arrays;

public class LargestElement{

    // O(n log n), O(1)
    public static int findLargest_bruteforce(int arr[]){
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }

    // O(n), O(1)
    public static int findLargest_optimal(int arr[]){
        int max = Integer.MIN_VALUE;

        int len = arr.length;

        for(int i=0; i<len; i++){
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public static void main(String args[]){
        int arr[] = {2,5,6,9,10,1,0};

        System.out.println("Largest element in the given array (brute-force approach): " + findLargest_bruteforce(arr));

        System.out.println("Largest element in the given array (optimal approach): " + findLargest_optimal(arr));
    }
}