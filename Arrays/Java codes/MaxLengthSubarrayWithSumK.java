import java.util.*;

public class MaxLengthSubarrayWithSumK{

    // bruteforce - O(n^2), O(1)
    public static int findMaxLength_brute(int arr[], int target){
        int n = arr.length;

        int maxLen = 0;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum == target){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }

    // better - O(n), O(n) -- optimal for arrays with all negative elements
    public static int findMaxLength_better(int arr[], int target){
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        int maxLen = 0;
        
        for(int i=0; i<n; i++){
            sum += arr[i];

            if(sum == target){
                maxLen = Math.max(maxLen, i+1);
            }

            if(map.containsKey(sum - target)){
                maxLen = Math.max(maxLen, i-map.get(sum - target));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    // optimal - O(n), O(1) -- does not work in case of arrays with negative elements
    public static int findMaxLength_optimal(int arr[], int target){
        int n = arr.length;

        int i = 0;
        int j = 0;

        int sum = 0;

        int maxLen = 0;

        while(j < n){
            sum+=arr[j];
            while(i <= j && sum > target){
                sum -= arr[i];
                i++;
            }
            if(sum == target){
                maxLen = Math.max(maxLen, j-i+1);
            }
            j++;
        }

        return maxLen;
    }

    public static void main(String args[]){
        int arr[] = {1,-3,-2,5,-7,6};
        int target = -7;

        System.out.println(findMaxLength_brute(arr, target));

        System.out.println(findMaxLength_better(arr, target));

        System.out.println(findMaxLength_optimal(arr, target));
    }
}