import java.util.*;

public class MajorityElement {

    // bruteforce - O(n^2), O(1)
    public static int findMajorityElement_brute(int arr[]){
        int n = arr.length;

        for(int i=0; i<n; i++){
            int freq = 0;
            for(int j=i; j<n; j++){
                if(arr[j] == arr[i]){
                    freq++;
                }
            }
            if(freq>n/2){
                return arr[i];
            }
        }

        return -1;
    }

    // better - O(n), O(1)
    public static int findMajorityElement_better(int arr[]){
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            if(map.get(arr[i]) > n/2){
                return arr[i];
            }
        }

        return -1;
    }

    // optimal - O(n), O(1)
    public static int findMajorityElement_optimal(int arr[]){
        int n = arr.length;

        int ele = arr[0];
        int freq = 1;
        
        for(int i=1; i<n; i++){
            if(freq == 0){
                ele = arr[i];
            }
            if(arr[i] == ele){
                freq++;
            }
            else{
                freq--;
            }
        }

        freq = 0;

        for(int i=0; i<n; i++){
            if(arr[i] == ele){
                freq++;
            }
            if(freq > n/2){
                return ele;
            }
        }

        return -1;
    }
 
    public static void main(String args[]){
        int arr[] = {1,2,5,4,2,3,2};

        System.out.println(findMajorityElement_brute(arr));

        System.out.println(findMajorityElement_better(arr));

        System.out.println(findMajorityElement_optimal(arr));
    }
}
