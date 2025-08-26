import java.util.Arrays;

public class SecondLargest {

    // bruteforce - O(n log n), O(1)
    public static int findSecondLargest_bruteforce(int arr[]){
        int len = arr.length;

        Arrays.sort(arr);

        int largest = arr[len - 1];
        int secondLargest = -1;

        for(int i=len-2; i>=0; i--){
            if(arr[i] < largest){
                secondLargest = arr[i];
                break;
            }
        }

        return secondLargest;
    }

    // better - O(2n), O(1)
    public static int findSecondLargest_better(int arr[]){
        int len = arr.length;

        int largest = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){
            largest = Math.max(largest, arr[i]);
        }

        int secondLargest = -1;

        for(int i=0; i<len; i++){
            if(arr[i] != largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    // optimal - O(n), O(1)
    public static int findSecondLargest_optimal(int arr[]){
        int len = arr.length;

        int largest = Integer.MIN_VALUE;
        int secondLargest = -1;

        for(int i=0; i<len; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] < largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }
        }

        return Math.max(-1, secondLargest);
    }
    
    public static void main(String args[]){
        int arr[] = {2,4,5,10,45,10,45,7};

        System.out.println("The second largest using brute-force approach: " + findSecondLargest_bruteforce(arr));

        System.out.println("The second largest using better approach: " + findSecondLargest_better(arr));

        System.out.println("The second largest using optimal approach: " + findSecondLargest_optimal(arr));
    }
}
