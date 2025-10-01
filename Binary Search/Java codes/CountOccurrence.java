public class CountOccurrence {

    // bruteforce - O(n), O(1)
    public static int countOccurrence_brute(int arr[], int m){
        int n = arr.length;

        int first = -1;
        int last = -1;

        for(int i=0; i<n; i++){
            if(arr[i] == m){
                first = first == -1 ? i : first;
                last = i;
            }
        }

        return last-first+1;
    }

    // optimal - O(2 log n), O(1)
    public static int countOccurrence_optimal(int arr[], int m){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int first = -1;
        int last = -1;

        // find first occurrence
        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == m){
                first = mid;
                high = mid-1;
            }

            else if(arr[mid] < m){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        low = 0;
        high = n-1;

        // find last occurrence
        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == m){
                last = mid;
                low = mid+1;
            }

            else if(arr[mid] < m){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return last-first+1;
    }
    
    public static void main(String args[]){
        int arr[] = {2,4,6,8,8,8,11,13};
        int m = 8;

        System.out.println("No. of occurrences: " + countOccurrence_brute(arr, m));

        System.out.println("No. of occurrences: " + countOccurrence_optimal(arr, m));

    }
}
