public class KthMissingPositive {

    // optimal - O(log n), O(1)
    public static int findMissing(int arr[], int k){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int missing = arr[mid] - mid + 1;

            if(missing <= k) low = mid+1;

            else high = mid-1;
        }

        return low+k;
    }
    
    public static void main(String args[]){
        int arr[] = {4,7,9};
        int k = 3;

        System.out.println(findMissing(arr, k));
    }
}
