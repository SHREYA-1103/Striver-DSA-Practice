
public class CheckIfArrayRepresentsMinHeap {

    public static boolean checkMinHeap(int arr[]){
        int n = arr.length;

        for(int i=0; i<n/2; i++){
            int leftIdx = 2*i+1;
            int rightIdx = 2*i+2;
            if(leftIdx < n && arr[i] > arr[leftIdx]){
                return false;
            }
            if(rightIdx < n && arr[i] > arr[rightIdx]){
                return false;
            }
        }

        return true;
    }
    
    public static void main(String args[]){
        int arr[] = {2,3,4,5,1,7};

        System.out.println(checkMinHeap(arr));
    }
}
