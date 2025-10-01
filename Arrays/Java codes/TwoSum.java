// this code returns the two elements in the array which add up to the target sum, alternatively this can also be modified to return true/false that is whether two such elements exist or not and also to return indices of those elements

import java.util.*;

public class TwoSum {

    // bruteforce - O(n^2), O(1)
    public static int[] findIndices_brute(int arr[], int target){
        int n = arr.length;

        int res[] = new int[2];
        Arrays.fill(res, -1);

        for(int i=0; i<n; i++){
            boolean found = false;
            for(int j=i+1; j<n; j++){
                if(arr[i] + arr[j] == target){
                    found = true;
                    res[i] = arr[i];
                    res[1] = arr[j];
                    break;
                }
            }
            if(found){
                break;
            }
        }

        return res;
    }

    // better - O(n), O(n)
    public static int[] findIndices_better(int arr[], int target){
        int n = arr.length;

        int res[] = new int[2];
        Arrays.fill(res, -1);

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            if(map.containsKey(target-arr[i])){
                res[0] = target-arr[i];
                res[1] = arr[i];
                break;
            }
            map.put(arr[i], i);
        }

        return res;
    }

    // optimal - O(n log n)
    public static int[] findIndices_optimal(int arr[], int target){
        int n = arr.length;

        int left = 0;
        int right = n-1;

        Arrays.sort(arr);

        int res[] = new int[2];

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                res[0] = arr[left];
                res[1] = arr[right];
                break;
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }

        return res;
    }
    
    public static void main(String args[]){
        int arr[] = {1,3,2,4,6,0};
        int target = 5;

        int idx1[] = findIndices_brute(arr, target);
        System.out.println(idx1[0] + " " + idx1[1]);

        int idx2[] = findIndices_better(arr, target);
        System.out.println(idx2[0] + " " + idx2[1]);

        int idx3[] = findIndices_optimal(arr, target);
        System.out.println(idx3[0] + " " + idx3[1]);
    }
}
