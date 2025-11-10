// ---------------------------------- Ques ------------------------------
// Given a rod of length n and an n length array stating the prices of each ith length piece, cut the rod into optimized number of pieces for selling such that the maximum profit can be earned.
// ----------------------------------------------------------------------


public class RodCutting {

    public static int maxProfit_tab(int n, int prices[]){
        int dp[][] = new int[n][n+1];

        for(int j=0; j<=n; j++){
            dp[0][j] = j*prices[0]; // using only pieces of length 1
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=n; j++){
                int notCut = dp[i-1][j];
                int cut = 0;
                int rodLength = i+1;

                if(rodLength <= j){
                    cut = prices[i] + dp[i][j-rodLength];
                }

                dp[i][j] = Math.max(cut, notCut);
            }
        }
        
        return dp[n-1][n];
    }   
    
    public static void main(String args[]){
        int n = 5;
        int prices[] = {2,5,7,8,10};

        System.out.println(maxProfit_tab(n, prices));

        // System.out.println(maxProfit_so(n, prices));
    }
}
