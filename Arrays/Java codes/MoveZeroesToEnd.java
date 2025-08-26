import java.util.*;

public class MoveZeroesToEnd {

    // bruteforce - O(2n), O(n)
    public static void moveZeroes_brute(int arr[]){
        int n = arr.length;

        List<Integer> temp = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                temp.add(arr[i]);
            }
        }

        for(int i=0; i<temp.size(); i++){
            arr[i] = temp.get(i);
        }

        for(int i=temp.size(); i<n; i++){
            arr[i] = 0;
        }
    }
    
    // optimal - O(n), O(1)
    public static void moveZeroes_optimal(int arr[]){
        int n = arr.length;

        int j = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                arr[j] = arr[i];
                j++;
            }
        }

        while(j < n){
            arr[j] = 0;
            j++;
        }
    }
    
    public static void main(String args[]){
        int arr[] = {1,3,2,4,0,5,0,1,0,2,0,0};

        moveZeroes_optimal(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
