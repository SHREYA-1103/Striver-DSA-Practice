import java.util.HashSet;

public class RemoveDuplicatesInPlaceSortedArray {
    
    // bruteforce - O(n log n), O(n)
    public static int removeDuplicates_brute(int arr[], int arr1[]) {
        HashSet<Integer> set = new HashSet<>();

        int len = arr.length;

        for(int i=0; i<len; i++){
            set.add(arr[i]); // O(n log n)
            arr1[i] = arr[i];
        }

        int idx = 0;

        for(int i: set){
            arr1[idx] = i;
            idx++;
        }

        return idx;
    }

    // optimal - O(n), O(1)
    public static int removeDuplicates_optimal(int arr[], int arr2[]){
        int i = 0;
        int j = 1;

        int len = arr.length;

        System.arraycopy(arr, 0, arr2, 0, len);

        while(j<len){
            if(arr2[i] != arr2[j]){
                arr2[i++] = arr[j];
            }
            j++;
        }

        return i+1;
    }

    public static void main(String args[]){
        int arr[] = {1,1,2,2,3,3,3,3};

        int arr1[] = new int[arr.length];
        int arr2[] = new int[arr.length];

        int uniqueCount = removeDuplicates_brute(arr, arr1);

        System.out.println("Total number of unique elements in the array (brute-force approach): " + uniqueCount);
        
        for(int i=0; i<uniqueCount; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        uniqueCount = removeDuplicates_optimal(arr, arr2);

        System.out.println("Total number of unique elements in the array (optimal approach): " + uniqueCount);
        
        for(int i=0; i<uniqueCount; i++){
            System.out.print(arr2[i] + " ");
        }
    }
}
