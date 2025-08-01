
public class CheckIfSorted {

    // O(n), O(1)
    public static boolean isSorted(int arr[]){
        int len = arr.length;

        for(int i=1; i<len; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }

        return true;
    }
    
    public static void main(String args[]){
        int arr[] = {1,4,5,7,8};

        System.out.println(isSorted(arr));
    }
}
