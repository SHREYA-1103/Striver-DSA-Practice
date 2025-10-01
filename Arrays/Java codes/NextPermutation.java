import java.util.*;

public class NextPermutation {

    // Optimal - O(n log n), O(1)
    public static int[] nextPermutation(int arr[]){
        int n = arr.length;

        int idx = -1;

        for(int i=n-2; i>=0; i--){ // find the break point index, such that if this can be increased and the remaining sequence be put in increasing order we will get the next permutation
            if(arr[i] < arr[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){ // we already have the last possible permutation and hence the answer is the first permutation
            Arrays.sort(arr);
            return arr;
        }

        int minDiff = Integer.MAX_VALUE;

        int idx2 = -1;

        for(int i=n-1; i>idx; i--){ // find the element to swap with
            int diff = arr[i] - arr[idx];
            if(diff > 0 && diff < minDiff){
                minDiff = diff;
                idx2 = i;
            }
        }

        int temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;

        Arrays.sort(arr, idx+1, n);

        return arr;
    }
    
    public static void main(String args[]){
        int arr[] = {2,1,4,3};

        int arr2[] = nextPermutation(arr);

        for(int val: arr2) System.out.println(val);
    }
}
