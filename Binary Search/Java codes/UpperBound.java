public class UpperBound{

    // bruteforce - O(n), O(1)
    public static int findUpperBound_brute(int arr[], int target){
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(arr[i] > target){
                return i;
            }
        }

        return n;
    }
    
    // optimal - O(log n), O(1)
    public static int findUpperBound_optimal(int arr[], int target){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int minIdx = n;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] > target){
                high = mid-1;
                minIdx = Math.min(minIdx, mid);
            }
            else{
                low = mid+1;
            }
        }

        return minIdx;
    }

    public static void main(String args[]){
        int arr[] = {1,3,5,8,9,10,10};
        int target = 10;

        System.out.println(findUpperBound_brute(arr, target));

        System.out.println(findUpperBound_optimal(arr, target));
    }
}