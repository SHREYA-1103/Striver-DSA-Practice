import java.util.*;

public class AggressiveCows {

    public static boolean canWePlace(int stalls[], int cows, int minDist){
        int n = stalls.length;

        int prev = 0; // location of the prev cow
        int count = 1;

        for(int i=1; i<n; i++){
            if(stalls[i] - stalls[prev] >= minDist){
                count++;
                prev = i;
            }
        }

        return count >= cows;
    }

    public static int maxMinDiff(int stalls[], int cows){
        int n = stalls.length;
        
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n-1] - stalls[0];

        int maxMinDist = 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(canWePlace(stalls, cows, mid)){
                maxMinDist = mid;
                low = mid+1; // find even high min distance if possible
            }
            else{
                high = mid-1;
            }
        }

        return maxMinDist;
    }
    
    public static void main(String args[]){
        int stalls[] = {0,3,4,7,9,10};
        int k = 4;

        System.out.println(maxMinDiff(stalls, k));
    }
}
