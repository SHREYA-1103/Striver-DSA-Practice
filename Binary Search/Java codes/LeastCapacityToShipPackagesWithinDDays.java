public class LeastCapacityToShipPackagesWithinDDays {

    public static boolean isPossible(int[] packages, int days, int cap){
        int n = packages.length;

        int count = 0;

        int currSum = 0;
        
        for (int i = 0; i < n; i++) {
            currSum += packages[i];

            if(currSum > cap){
                count++;
                currSum = packages[i];
            }

            else if(currSum == cap){
                count++;
                currSum = 0;
            }

            if(count > days) return false;
        }

        count++;

        return count <= days;
    }

    // Optimal - O(n log(sum of packages))
    public static int minCapacity(int packages[], int days){
        int n = packages.length;
        
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max, packages[i]);
            sum += packages[i];
        }

        int low = max;
        int high = sum;

        int minCap = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(packages, days, mid)){ // if mid is the possible answer
                minCap = mid;
                high = mid-1; // search left for even smaller minCap
            }
            else{
                low = mid+1;
            }
        }

        return minCap;
    }
    
    public static void main(String args[]){
        int packages[] = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(minCapacity(packages, days));
    }
}
