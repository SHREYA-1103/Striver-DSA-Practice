// -------------------------------- Ques --------------------------------
// Given two arrays with details about n items, val[i] denoting the value of the ith item and wt[i] denoting the weight of the ith item along with the capacity of a bag. Find the maximum valued items that can be kept in the bag such the combined weight of the selected items is less than or equal to the given capacity. Assume that there is unlimited supply of each item available.
// ----------------------------------------------------------------------

public class UnboundedKnapsack {

    // O(n*cap), O(n*cap)
    public static int maxValue_tab(int val[], int wt[], int capacity){
        int n = val.length;

        int dp[][] = new int[n+1][capacity+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=capacity; j++){
                if(j >= wt[i-1]){
                    // pick or not pick
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    // O(n*cap), O(cap)
    public static int maxValue_so(int val[], int wt[], int capacity){
        int n = val.length;

        int dp[] = new int[capacity+1];

        for(int i=0; i<n; i++){
            for(int j=wt[i]; j<=capacity; j++){
                if(j >= wt[i]){
                    // pick or not pick
                    dp[j] = Math.max(val[i] + dp[j-wt[i]], dp[j]);
                }
            }
        }

        return dp[capacity];
    }
    
    public static void main(String args[]){
        int val[] = {30,50,60};
        int wt[] = {3,4,5};
        int capacity = 8;

        System.out.println(maxValue_tab(val, wt, capacity));

        System.out.println(maxValue_so(val, wt, capacity));
    }
}
