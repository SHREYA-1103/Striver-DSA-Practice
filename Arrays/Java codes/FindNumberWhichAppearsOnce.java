import java.util.*;

public class FindNumberWhichAppearsOnce {

    // bruteforce - O(n^2), O(1)
    public static int findOneOccurence_brute(int arr[]){
        int n = arr.length;

        for(int i=0; i<n; i++){
            boolean repeat = false;
            for(int j=0; j<n; j++){
                if(i != j && arr[i] == arr[j]){
                    repeat = true;
                }
            }
            if(!repeat){
                return arr[i];
            }
        }

        return -1;
    }

    // better - O(2n), O(n)
    public static int findOneOccurence_better(int arr[]){
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }

        return -1;
    }

    // optimal - O(n), O(1)
    public static int findOneOccurence_optimal(int arr[]){
        int n = arr.length;

        int xor = 0;
        
        for(int i=0; i<n; i++){
            xor ^= arr[i];
        }

        return xor;
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,2,4,4,7,1};

        System.out.println(findOneOccurence_brute(arr));

        System.out.println(findOneOccurence_better(arr));

        System.out.println(findOneOccurence_optimal(arr));
    }
}

