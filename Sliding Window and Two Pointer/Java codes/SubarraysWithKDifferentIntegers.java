import java.util.*;

public class SubarraysWithKDifferentIntegers {

    public static int countSubarrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    public static int atMost(int[] arr, int k) {
        int n = arr.length;

        int l = 0, r = 0, count = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        while (r < n) {
            freq.put(arr[r], freq.getOrDefault(arr[r], 0) + 1);

            if (freq.get(arr[r]) == 1) {
                k--; 
            }

            while (k < 0) {
                freq.put(arr[l], freq.get(arr[l]) - 1);
                if (freq.get(arr[l]) == 0) {
                    k++;
                }
                l++;
            }

            count += r - l + 1;
            r++;
        }

        return count;
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,1,3,4};
        int k = 3;

        System.out.println(countSubarrays(arr, k));
    }
}
