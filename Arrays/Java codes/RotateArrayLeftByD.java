
public class RotateArrayLeftByD {

    // bruteforce - O(n+d), O(d)
    public static void rotateLeft_brute(int arr[], int d){
        int temp[] = new int[d];

        int n = arr.length;

        System.arraycopy(arr, 0, temp, 0, d);

        for(int i=d; i<n; i++){
            arr[i-d] = arr[i]; 
        }

        for(int i=0; i<d; i++){
            arr[i+n-d] = temp[i];
        }
    }
    
    // optimal - O(2n), O(1)
    public static void rotateLeft_optimal(int arr[], int d){
        int n = arr.length;

        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }

    public static void reverse(int arr[], int start, int end){
       while(start <= end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
       }
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6};
        int d = 8;

        int n = arr.length;
        rotateLeft_optimal(arr, d%n);

        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
