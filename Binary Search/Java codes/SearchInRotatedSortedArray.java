public class SearchInRotatedSortedArray {

    // bruteforce - O(n), O(1)
    public static int find_brute(int arr[], int m){
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(arr[i] == m){
                return i;
            }
        }

        return -1;
    }

    // optimal - O(log n), O(1)
    public static int find_optimal(int arr[], int m){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int idx = n;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == m){
                idx = Math.min(mid, idx); // in case of array with duplicate elements, to find the first occurrence
                high = mid-1;
            }

            else if(arr[low] <= arr[mid]){ // left half is sorted
                if(m >= arr[low] && m <= arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }

            else{ // right half is sorted
                if(m >= arr[mid] && m <= arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }

        return idx == n ? -1:idx;
    }
    
    public static void main(String args[]){
        int arr[] = {3,1,2,4,4,4,4};
        int m = 4;

        System.out.println(find_brute(arr, m));

        System.out.println(find_optimal(arr, m));
    }
}
