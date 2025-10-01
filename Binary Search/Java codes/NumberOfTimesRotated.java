public class NumberOfTimesRotated {

    // bruteforce - O(n), O(1)
    public static int rotatedTimes_brute(int arr[]){
        int n = arr.length;

        int minIdx = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            if(arr[i] < min){
                min = arr[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    // optimal - O(log n), O(1)
    public static int rotatedTimes_optimal(int arr[]){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int min = Integer.MAX_VALUE;
        int minIdx = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[low] <= arr[mid]){ // sorted left half
                if(arr[low] < arr[minIdx]){
                    min = arr[low];
                    minIdx = low;
                }
                else if(arr[low] == min){
                    minIdx = Math.min(minIdx, low);
                }
                low = mid+1; // search in unsorted right half
            }

            else{ // sorted right half
                if(arr[mid] < arr[minIdx]){
                    min = arr[mid];
                    minIdx = mid;
                }
                else if(arr[mid] == min){
                    minIdx = Math.min(minIdx, mid);
                }
                high = mid-1; // search in unsorted left half
            }
        }

        return minIdx;
    }
    
    public static void main(String args[]){
        int arr[] = {3,3,3,3,1,2,3};

        System.out.println(rotatedTimes_brute(arr));

        System.out.println(rotatedTimes_optimal(arr));
    }
}
