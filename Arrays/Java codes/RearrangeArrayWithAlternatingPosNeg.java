public class RearrangeArrayWithAlternatingPosNeg {

    // bruteforce - O(2n), O(n)
    public static void arrangeAlternate_brute(int arr[]){
        int len = arr.length;

        int pos[] = new int[len/2];
        int neg[] = new int[len/2];

        int p = 0;
        int n = 0;

        for(int val: arr){
            if(val >= 0){
                pos[p++] = val;
            }
            else{
                neg[n++] = val;
            }
        }

        p = 0;
        n = 0;

        for(int i=0; i<len; i++){
            arr[i++] = pos[p++];
            arr[i] = neg[n++];
        }
    }

    // optimal - O(2n), O(1) -- only if maintaining the order isn't important
    public static void arrangeAlternate_optimal(int arr[]){
        int n = arr.length;

        int mid = n/2;

        int i = 0; // for storing all positive elements int he first half of the array

        // partition array in positives and negatives
        for(int k=0; k<n; k++){
            if(arr[k] >= 0){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        i = 0;
        int j = mid;

        // interleave positive and negative elements
        while(i < mid && j < n){
            int temp = arr[i+1];
            arr[i+1] = arr[j];
            arr[j] = temp;

            i+=2;
            j++;
        }
    }

    
    public static void main(String args[]){
        int arr[] = {3,2,-1,-5,3,-4};

        arrangeAlternate_brute(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        arrangeAlternate_optimal(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
