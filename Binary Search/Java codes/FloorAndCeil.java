public class FloorAndCeil {

    // optimal - O(log n), O(1)
    public static int findFloor(int arr[], int m){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int res = -1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(arr[mid] <= m){
                res = arr[mid];
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return res;
    }

    // optimal - O(log n), O(1)
    public static int findCeil(int arr[], int m){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int res = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] >= m){
                res = arr[mid];
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }

        return res;
    }
    
    public static void main(String args[]){
        int arr[] = {10,20,25,30,40,50};
        int m = 75;

        System.out.println("floor: " + findFloor(arr, m));

        System.out.println("ceil: " + findCeil(arr, m));
    }
}
