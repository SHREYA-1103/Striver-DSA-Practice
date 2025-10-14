public class SplitArrayLargestSum {

    public static boolean isPossible(int[] arr, int k, int maxSum){
        int n = arr.length;

        int count = 1;

        int currSum = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i] > maxSum)
                return false;

            if(currSum + arr[i] <= maxSum){
                currSum += arr[i];
            }
            else{
                count++;
                currSum = arr[i];
            }

            if(count > k)
                return false;
        }

        return true;
    }

    // optimal - O(n log(sum of elements))
    public static int minTime(int arr[], int k){
        int n = arr.length;

        if(n < k){
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int low = max;
        int high = sum;

        int res = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(arr, k, mid)){
                res = mid;
                high = mid-1; // find even smaller possible min
            }
            else{
                low = mid+1;
            }
        }

        return res;
    }
    
    public static void main(String args[]){
        int arr[] = {10,20,30,40};
        int k = 2;

        System.out.println(minTime(arr, k));
    }
}

