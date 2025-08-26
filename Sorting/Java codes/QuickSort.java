public class QuickSort {
    
    // Optimal - O(n log n) (average) or O(n^2) (worst), O(1)
    public static void quickSortInc(int arr[], int start, int end){
        if(start >= end){
            return;
        }

        int pIdx = partitionInc(arr, start, end);

        quickSortInc(arr, start, pIdx-1);
        quickSortInc(arr, pIdx+1, end);
    }

    public static int partitionInc(int arr[], int start, int end){
        int pivot = end;

        int i = start-1;

        for(int j=start; j<end; j++){
            if(arr[j] <= arr[pivot]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;

        return i;
    }

    // Optimal - O(n log n) (average) or O(n^2) (worst), O(1)
    public static void quickSortDec(int arr[], int start, int end){
        if(start >= end){
            return;
        }

        int pIdx = partitionDec(arr, start, end);

        quickSortDec(arr, start, pIdx-1);
        quickSortDec(arr, pIdx+1, end);
    }

    public static int partitionDec(int arr[], int start, int end){
        int pivot = arr[end];

        int i = start-1;

        for(int j=start; j<end; j++){
            if(arr[j] >= arr[pivot]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;

        return i;
    }

    public static void main(String args[]){
        int arr[] = {3,5,2,7,6,9,1};

        quickSortInc(arr, 0, arr.length-1);

        System.out.println("Array sorted in increasing order:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        quickSortDec(arr, 0, arr.length-1);

        System.out.println("Array sorted in decreasing order:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
