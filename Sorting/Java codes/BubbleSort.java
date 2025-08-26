public class BubbleSort {
    
    // Bruteforce - O(n^2), O(n^2)
    public static void bubbleSortInc_brute(int arr[], int n){
        if(n == 1){
            return;
        }

        int swaps = 0;
        
        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                swaps++;
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        if(swaps == 0){
            return;
        }

        bubbleSortInc_brute(arr, n-1);
    }

    // Optimal - O(n^2), O(1)
    public static void bubbleSortInc(int arr[]){
        int n = arr.length;

        for(int i=1; i<n; i++){ // n-1 iterations
            int swaps = 0;
            for(int j=0; j<n-i; j++){ // compare every pair of adjacent elements
                if(arr[j] > arr[j+1]){
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(swaps==0){ // early stopping condition
                break;
            }
        }
    }

    // Bruteforce - O(n^2), O(n^2)
    public static void bubbleSortDec_brute(int arr[], int n){
        if(n == 1){
            return;
        }

        int swaps = 0;
        
        for(int i=0; i<n-1; i++){
            if(arr[i] < arr[i+1]){
                swaps++;
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        if(swaps == 0){
            return;
        }

        bubbleSortDec_brute(arr, n-1);
    }

    // Optimal - O(n^2), O(1)
    public static void bubbleSortDec(int arr[]){
        int n = arr.length;

        for(int i=1; i<n; i++){ // n-1 iterations
            int swaps = 0;
            for(int j=0; j<n-i; j++){ // compare every pair of adjacent elements
                if(arr[j] < arr[j+1]){
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(swaps == 0){ // early stopping condition
                break;
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {1,6,2,6,3,3,4,5};

        bubbleSortInc(arr);

        System.out.println("Array sorted in increasing order:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubbleSortDec(arr);
        
        System.out.println("Array sorted in decreasing order:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
