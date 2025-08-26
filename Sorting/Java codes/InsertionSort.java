public class InsertionSort {
    
    // Bruteforce - O(n^2), O(n^2)
    public static void insertionSortInc_brute(int arr[], int n){
        if(n <= 1){
            return;
        }

        insertionSortInc_brute(arr, n-1);
        
        int j = n-1;
        while(j>0 && arr[j]<=arr[j-1]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        } 
    }
    
    // Optimal - O(n^2), O(1)
    public static void insertionSortInc(int arr[]){
        int n = arr.length;

        for(int i=1; i<n; i++){
            int j = i;
            while(j>0 && arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    // Bruteforce - O(n^2), O(n^2)
    public static void insertionSortDec_brute(int arr[], int n){
        if(n <= 1){
            return;
        }

        insertionSortDec_brute(arr, n-1);

        int j = n-1;
        while(j>0 && arr[j]>=arr[j-1]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        } 
    }

    // Optimal - O(n^2), O(1)
    public static void insertionSortDec(int arr[]){
        int n = arr.length;

        for(int i=1; i<n; i++){
            int j = i;
            while(j>0 && arr[j]>arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {1,5,3,6,3,9};

        insertionSortInc_brute(arr, arr.length);
        // insertionSortInc(arr);

        System.out.println("Array sorted in increasing order:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        insertionSortDec_brute(arr, arr.length);
        // insertionSortDec(arr);

        System.out.println("Array sorted in decreasing order:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
