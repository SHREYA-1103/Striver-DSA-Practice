
public class RotateArrayLeftBy1 {

    // optimal - O(n), O(1)
    public static void rotateLeft(int arr[]){
        int num = arr[0];

        for(int i=1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }

        arr[arr.length-1] = num;
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6};

        rotateLeft(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
