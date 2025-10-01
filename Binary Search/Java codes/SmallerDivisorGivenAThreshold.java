public class SmallerDivisorGivenAThreshold {

    // bruteforce - O(n + n*max), O(1)
    public static int minDivisor_brute(int nums[], int threshold){
        int n = nums.length;

        if(threshold < n){
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
        }

        for(int i=1; i<=max; i++){
            if(isPossible(nums, threshold, i)){ // if i is the possible divisor
                return i;
            }
        }

        return -1;
    }

    // o(n)
    public static boolean isPossible(int nums[], int threshold, int currDiv){
        int n = nums.length;

        int sum = 0;

        for(int i=0; i<n; i++){
            sum += nums[i]/currDiv;
            if(nums[i] % currDiv != 0){
                sum++;
            }
            if(sum > threshold){
                return false;
            }
        }

        return true;    
    }

    // optimal - O(n + n*log max), O(1)
    public static int minDivisor_optimal(int nums[], int threshold){
        int n = nums.length;

        if(threshold < n){
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
        }

        int low = 1;
        int high = max;

        int min = max; // min possible divisor

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(nums, threshold, mid)){ // if mid is the possible divisor
                min = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return min;
    }
    
    public static void main(String arg[]){
        int nums[] = {1,2,5,9};
        int threshold = 6;

        System.out.println(minDivisor_brute(nums, threshold));

        System.out.println(minDivisor_optimal(nums, threshold));
    }
}
