public class SelectionSort {

    // Optimal - O(n^2), O(1)
    public static void selectionSortInc(int arr[]){
        int n = arr.length;
        
        // for sorting in increasing order, for each position, find the smallest element in the unsorted part of the array
        for(int i=0; i<n; i++){
            int minPos = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minPos]){
                    minPos = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    // Optimal - O(n^2), O(1)
    public static void selectionSortDec(int arr[]){
        int n = arr.length;

        // for sorting in decreasing order, for each position, find the largest element in the unsorted part of the array
        for(int i=0; i<n; i++){
            int maxPos = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] > arr[maxPos]){
                    maxPos = j;
                }
            }
            int temp = arr[maxPos];
            arr[maxPos] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String args[]){
        int arr[] = {2,5,6,3,1};

        selectionSortInc(arr);

        System.out.println("Sorted array in increasing order:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        selectionSortDec(arr);

        System.out.println("Sorted array in decreasing order:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
