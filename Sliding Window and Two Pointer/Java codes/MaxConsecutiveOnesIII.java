public class MaxConsecutiveOnesIII {

    // optimal - O(n), O(1)
    public static int maxOnes(int arr[], int k){
        int n = arr.length;

        int l = 0;
        int r = 0;

        int countZeroes = 0;

        int max = 0;

        while(r < n){
            if(arr[r] == 0) countZeroes++;

            if(countZeroes > k){
                if(arr[l] == 0) countZeroes--;
                l++;
            }

            max = Math.max(max, r-l+1);
            r++;
        }

        return max;
    }
    
    public static void main(String args[]){
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2; // these many values can be flipped

        System.out.println(maxOnes(arr, k));
    }
}
