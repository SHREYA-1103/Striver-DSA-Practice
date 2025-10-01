public class FindPeakElement {

    public static int findPeak_brute(int arr[]){
        int n = arr.length;

        if(n == 1){
            return arr[0]; // left and right ends are assumed to be -inf
        }

        else if(arr[0] > arr[1]){
            return arr[0];
        }

        else if(arr[n-1] > arr[n-2]){
            return arr[n-1];
        }

        for(int i=1; i<n-1; i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                return arr[i];
            }
        }

        return -1;
    }

    public static int findPeak_optimal(int arr[]){
        int n = arr.length;

        if(n == 1){
            return arr[0]; // left and right ends are assumed to be -inf
        }

        else if(arr[0] > arr[1]){
            return arr[0];
        }

        else if(arr[n-1] > arr[n-2]){
            return arr[n-1];
        }

        int low = 1;
        int high = n-2;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }

            else if(arr[mid] > arr[mid-1]){ // you are on increasing part of the array -> peak on right
                low = mid+1;
            }

            else{ // you are on the decreasing part of the array -> peak on left
                high = mid-1;
            }
        }

        return -1;
    }
    
    public static void main(String args[]){
        int arr[] = {5,6,7,8,9,1,0};

        System.out.println(findPeak_brute(arr));

        System.out.println(findPeak_optimal(arr));
    }
}
