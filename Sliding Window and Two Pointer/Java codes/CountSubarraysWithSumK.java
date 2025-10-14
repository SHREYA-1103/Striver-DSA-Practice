public class CountSubarraysWithSumK {

    public static int countSubarrays(int[] arr, int goal) {
        return atMost(arr, goal) - atMost(arr, goal - 1);
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
        int arr[] = {1,0,1,0,1};
        int goal = 2;

        System.out.println(countSubarrays(arr, goal));
    }
}
