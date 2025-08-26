public class MergeSort {
    
    // Optimal - O(n log n ), O(n)
    public static void mergeSortInc(int arr[], int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end-start)/2;

        mergeSortInc(arr, start, mid);
        mergeSortInc(arr, mid+1, end);

        mergeInc(arr, start, mid, end);
    }

    public static void mergeInc(int arr[], int start, int mid, int end){
        int i = start; // pointer for left array
        int j = mid+1; // pointer for right array

        int temp[] = new int[end-start+1];
        int k = 0; // pointer for temp array

        // put all elements combined in the temp array in the sorted order
        while(i <= mid && j <= end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }

        // put the elements fromt he temp array to the actual array
        for(i=start, k=0; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    // Optimal - O(n log n), O(n)
    public static void mergeSortDec(int arr[], int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end-start)/2;

        mergeSortDec(arr, start, mid);
        mergeSortDec(arr, mid+1, end);

        mergeDec(arr, start, mid, end);
    }

    public static void mergeDec(int arr[], int start, int mid, int end){
        int i = start; // pointer for left array
        int j = mid+1; // pointer for right array

        int temp[] = new int[end-start+1];
        int k = 0; // pointer for temp array

        // put all elements combined in the temp array in the sorted order
        while(i <= mid && j <= end){
            if(arr[i] > arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }

        // put the elements fromt he temp array to the actual array
        for(i=start, k=0; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]){
        int arr[] = {3,5,2,8,3,1,9};

        mergeSortInc(arr, 0, arr.length-1);

        System.out.println("Sorted array in increasing order: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        mergeSortDec(arr, 0, arr.length-1);

        System.out.println("Sorted array in decreasing order: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
