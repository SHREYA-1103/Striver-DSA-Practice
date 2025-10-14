public class PaintersPartition {

    public static boolean isPossible(int[] areaUnits, int painters, int maxTime){
        int n = areaUnits.length;

        int count = 1;

        int currTime = 0;
        
        for(int i = 0; i < n; i++){
            if(areaUnits[i] > maxTime)
                return false;

            if(currTime + areaUnits[i] <= maxTime){
                currTime += areaUnits[i];
            }
            else{
                count++;
                currTime = areaUnits[i];
            }

            if(count > painters)
                return false;
        }

        return true;
    }

    // optimal - O(n log(sum of area units))
    public static int minTime(int areaUnits[], int painters){
        int n = areaUnits.length;

        if(n < painters){
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max, areaUnits[i]);
            sum += areaUnits[i];
        }

        int low = max;
        int high = sum;

        int res = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(areaUnits, painters, mid)){
                res = mid;
                high = mid-1; // find even smaller possible min
            }
            else{
                low = mid+1;
            }
        }

        return res;
    }
    
    public static void main(String args[]){
        int areaUnits[] = {10,20,30,40};
        int painters = 2;

        System.out.println(minTime(areaUnits, painters));
    }
}

