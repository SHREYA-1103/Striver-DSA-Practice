public class MinimumInRotatedSortedArray {

    // bruteforce - O(n), O(1)
    public static int findMin_brute(int arr[]){
        int n = arr.length;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            min = Math.min(min, arr[i]);
        }

        return min;
    }

    // optimal - O(log n), O(1)
    public static int findMin_optimal(int arr[]){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[low] <= arr[mid]){ // sorted left half
                min = Math.min(min, arr[low]);
                low = mid+1; // search in unsorted right half
            }

            else{ // sorted right half
                min = Math.min(min, arr[mid]);
                high = mid-1; // search in unsorted left half
            }
        }

        return min;
    }
    
    public static void main(String args[]){
        int arr[] = {3,3,3,3,1,2,3};

        System.out.println(findMin_brute(arr));

        System.out.println(findMin_optimal(arr));
    }
}
