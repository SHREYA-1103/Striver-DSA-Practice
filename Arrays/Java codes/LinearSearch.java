public class LinearSearch {

    // optimal - O(n), O(1)
    public static int linearSearch(int arr[], int key){
        int n = arr.length;

        int idx = -1;

        for(int i=0; i<n; i++){
            if(arr[i] == key){
                idx = i;
                break;
            }
        }

        return idx;
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,3,6,5,4};
        int key = 1;

        System.out.println(linearSearch(arr, key));
    }
}
