public class BinarySearch {

    // optimal - O(log n), O(1)
    public static int binarySearch_iterative(int arr[], int target){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(target > arr[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return -1;
    }

    // optimal - O(log n), O(1)
    public static int binarySearch_rec(int arr[], int target, int low, int high){
        if(low > high){
            return -1;
        }

        int mid = low + (high-low)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(target > arr[mid]){
            low = mid+1;
            return binarySearch_rec(arr, target, low, high);
        }
        else{
            high = mid-1;
            return binarySearch_rec(arr, target, low, high);
        }
    }
    
    public static void main(String args[]){
        int arr[] = {1,4,6,9,10,13};
        int target = 4;

        System.out.println(binarySearch_iterative(arr, target));

        System.out.println(binarySearch_rec(arr, target, 0, arr.length-1));
    }
}
