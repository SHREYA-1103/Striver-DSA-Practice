public class KokoEatingBananas {

    // bruteforce - O(n + n*max), O(1)
    public static int minPerHour_brute(int bananas[], int h){
        int n = bananas.length;

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, bananas[i]);
        }

        for(int i=1; i<=max; i++){
            if(isPossible(bananas, i, h)){
                return i;
            }
        }

        return -1;
    }

    // O(n)
    public static boolean isPossible(int[] bananas, int currTime, int totalTime){
        int n = bananas.length;

        int time = 0;
        
        for(int i=0; i<n; i++){
            time += bananas[i]/currTime;
            if(bananas[i] % currTime != 0){
                time++;
            }
        }

        return time <= totalTime;
    }

    // optimal - O(n + n*log max), O(1)
    public static int minPerHour_optimal(int bananas[], int h){
        int n = bananas.length;

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, bananas[i]);
        }

        int low = 1;
        int high = max;

        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(bananas, mid, h)){ // if mid is the possible answer
                min = mid;
                high = mid-1; // search left for even min
            }
            else{
                low = mid+1;
            }
        }

        return min;
    }
    
    public static void main(String args[]){
        int bananas[] = {3,6,7,11};
        int h = 10;

        System.out.println(minPerHour_brute(bananas, h));

        System.out.println(minPerHour_optimal(bananas, h));
    }
}
