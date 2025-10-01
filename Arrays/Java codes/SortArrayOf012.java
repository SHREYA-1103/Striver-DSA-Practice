import java.util.*;

public class SortArrayOf012 {

    // bruteforce - O(n log n), O(1)
    public static void sort_brute(int arr[]){
        Arrays.sort(arr);
    }
    
    // better - O(2n), O(n)
    public static void sort_better(int arr[]){
        int n = arr.length;

        int freq[] = new int[3];

        for(int i=0; i<n; i++){
            freq[arr[i]]++;
        }

        int idx = 0;
        
        for(int i=0; i<freq[0]; i++){
            arr[idx++] = 0;
        }

        for(int i=0; i<freq[1]; i++){
            arr[idx++] = 1;
        }

        for(int i=0; i<freq[2]; i++){
            arr[idx++] = 2;
        }
    }

    // optimal - O(n) -- Dutch National Flag Algorithm
    public static void sort_optimal(int arr[]){
        int n = arr.length;

        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid<=high){
            int num = arr[mid];
            switch(num){
                case 0 -> {
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                }

                case 1 -> mid++;

                case 2 -> {
                    int temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                }
            }
        }
    }
    
    public static void main(String args[]){
        int arr[] = {0,1,2,1,1,0,2};

        sort_brute(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sort_better(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sort_optimal(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();        
    }
}
