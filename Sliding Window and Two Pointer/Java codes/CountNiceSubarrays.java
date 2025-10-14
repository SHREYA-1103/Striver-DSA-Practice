public class CountNiceSubarrays {

    public static int countNiceSubarrays(int[] arr, int k) {
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            arr[i] = arr[i]%2;
        }
        
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    public static int atMost(int[] arr, int goal) {
        if (goal < 0) return 0;

        int l = 0;
        int count = 0;
        int sum = 0;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];

            while (sum > goal) {
                sum -= arr[l++];
            }

            count += (r - l + 1);  
        }

        return count;
    }
    
    public static void main(String args[]){
        int arr[] = {1,1,2,1,1};
        int k = 3;

        System.out.println(countNiceSubarrays(arr, k));
    }
}
