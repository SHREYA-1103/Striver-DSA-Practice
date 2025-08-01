import java.util.Arrays;

public class SecondSmallest {

    // O(n log n), O(1)
    public static int findSecondSmallest_bruteforce(int arr[]){
        int len = arr.length;

        Arrays.sort(arr);

        int smallest = arr[0];
        int secondSmallest = -1;

        for(int i=1; i<len; i++){
            if(arr[i] > smallest){
                secondSmallest = arr[i];
                break;
            }
        }

        return secondSmallest;
    }

    // O(2n), O(1)
    public static int findSecondSmallest_better(int arr[]){
        int len = arr.length;

        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<len; i++){
            smallest = Math.min(smallest, arr[i]);
        }

        int secondSmallest = Integer.MAX_VALUE;

        for(int i=0; i<len; i++){
            if(arr[i] != smallest && arr[i] < secondSmallest){
                secondSmallest = arr[i];
            }
        }

        return secondSmallest == Integer.MAX_VALUE ? -1 : secondSmallest;
    }

    // O(n), O(1)
    public static int findSecondSmallest_optimal(int arr[]){
        int len = arr.length;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = -1;

        for(int i=0; i<len; i++){
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] > smallest && arr[i] < secondSmallest){
                secondSmallest = arr[i];
            }
        }

        return Math.max(-1, secondSmallest);
    }
    
    public static void main(String args[]){
        int arr[] = {2,4,5,10,45,10,45,7};

        System.out.println("The second smallest using brute-force approach: " + findSecondSmallest_bruteforce(arr));

        System.out.println("The second smallest using better approach: " + findSecondSmallest_better(arr));

        System.out.println("The second smallest using optimal approach: " + findSecondSmallest_optimal(arr));
    }
}
