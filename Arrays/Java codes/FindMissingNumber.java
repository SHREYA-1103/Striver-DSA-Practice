import java.util.*;

public class FindMissingNumber {

    // bruteforce - O(n^2), O(1)
    public static int findMissing_brute(int arr[]){
        int n = arr.length+1;

        for(int i=1; i<n+1; i++){
            boolean found = false;
            for(int j=0; j<arr.length; j++){
                if(arr[j] == i){
                    found = true;
                    break;
                }
            }
            if(!found){
                return i;
            }
        }

        return -1;
    }
    
    // better - O(2n), O(n)
    public static int findMissing_better(int arr[]){
        int n = arr.length+1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n-1; i++){
            map.put(arr[i], 1);
        }

        for(int i=1; i<n+1; i++){
            if(!map.containsKey(i)){
                return i;
            }
        }

        return -1;
    }
    
    // optimal - O(n), O(1)
    public static int findMissing_optimal_xor(int arr[]){
        int n = arr.length+1;

        int xor1 = 0;
        int xor2 = 0;
        
        for(int i=1; i<n; i++){
            xor1 = xor1 ^ arr[i-1];
            xor2 = xor2 ^ i;
        }

        xor2 = xor2 ^ n;

        return xor1 ^ xor2;
    }

    // optimal - O(n, O(1)
    public static int findMissing_optimal_sum(int arr[]){
        int n = arr.length+1;

        int sum1 = 0;
        int sum2 = 0;
        
        for(int i=1; i<n; i++){
            sum1 = sum1 + arr[i-1];
            sum2 = sum2 + i;
        }

        sum2 = sum2 + n;

        return sum2 - sum1;
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,5,4};

        System.out.println(findMissing_brute(arr));

        System.out.println(findMissing_better(arr));

        System.out.println(findMissing_optimal_xor(arr));

        System.out.println(findMissing_optimal_sum(arr));
    }
}
