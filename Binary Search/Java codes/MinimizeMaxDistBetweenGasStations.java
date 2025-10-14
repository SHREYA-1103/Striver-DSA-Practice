public class MinimizeMaxDistBetweenGasStations {

    public static int countGasStations(int gasStations[], double maxDist){
        int n = gasStations.length;
        
        int count = 0;

        for(int i=1; i<n; i++){
            int countInBetween = (int) ((gasStations[i] - gasStations[i-1]) / maxDist);

            if((gasStations[i] - gasStations[i-1]) / maxDist == countInBetween * maxDist){
                countInBetween++;
            }

            count+=countInBetween;
        }

        return count;
    }
    
    public static double minDist(int gasStations[], int k){
        int n = gasStations.length;
        
        double maxDiff = Double.MIN_VALUE;
        
        for(int i=1; i<n; i++){
            maxDiff = Math.max(maxDiff, gasStations[i] - gasStations[i-1]);
        }

        double low = 0.0;
        double high = maxDiff;

        double res = -1;
            
        // imp for binary search for ans of the form  long double or double 
        while(high - low > 0.000001){
            double mid = low + (high - low)/2.0;

            int count = countGasStations(gasStations, mid);

            if(count > k){
                low = mid;
            }

            else{
                res = high;
                high = mid;
            }
        }

        return res;
    }

    public static void main(String args[]){
        int gasStations[] = {1,2,3,4,5};
        int k = 4;

        System.out.println(minDist(gasStations, k));
    }
}
