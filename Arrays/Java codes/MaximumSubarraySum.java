public class MaximumSubarraySum {

    // bruteforce - O(n^3)
    public static int maxSum_brute(int arr[]){
        int n = arr.length;

        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = 0;
                for(int k=i; k<j; k++){
                    sum+=arr[k];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }

        return maxSum;
    }

    // better - O(n^2), O(n)
    public static int maxSum_better(int arr[]){
        int n = arr.length;

        int prefixSum[] = new int[n+1];

        prefixSum[0] = 0;

        for(int i=1; i<n+1; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n+1; i++){
            for(int j=i+1; j<n+1; j++){
                maxSum = Math.max(maxSum, prefixSum[j] - prefixSum[i]);
            }
        }

        return maxSum;
    }

    //optimal - O(n), O(1)
    public static int maxSum_optimal(int arr[]){
        int n = arr.length;

        boolean allNeg = true;
        
        int currSum = 0;
        int maxSum = -1;
        
        for(int i=0; i<n; i++){
            currSum = Math.max(0, currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
            if(arr[i] >=0){
                allNeg = false;
            }
        }

        // if all elements are negative, then the max sum of any subarray is actually the largest element of the array
        if(allNeg){
            int largest = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                largest = Math.max(largest, arr[i]);
            }
            return largest;
        }

        return maxSum;
    }
    
    public static void main(String args[]){
        int arr[] = {2,4,3,1,-3,-1};

        System.out.println(maxSum_brute(arr));

        System.out.println(maxSum_better(arr));

        System.out.println(maxSum_optimal(arr));
    }
}
