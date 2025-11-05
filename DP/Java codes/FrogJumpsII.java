import java.util.*;

public class FrogJumpsII {

    // Bruteforce (Recursion) - O(2^nk), O(2^nk)
    public static int minEnergy_rec(int n, int height[], int k){
        if(n == 0){
            return 0;
        }

        int jump = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++){
            jump = Math.min(jump, minEnergy_rec(n-i, height, k)+Math.abs(height[n]-height[i]));
        }
        
        return jump;
    }

    // Better (DP memoization) - O(nk), O(2n)
    public static int minEnergy_memo(int n, int height[], int dp[], int k){
        if(n == 0){
            return dp[n] = n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int jump = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++){
            jump = Math.min(jump, dp[n-i]+Math.abs(height[n]-height[n-i]));
        }
        
        return dp[n] = jump;
    }

    // Optimal1 (DP tabulation) - O(nk), O(n)
    public static int minEnergy_tab(int n, int height[], int k){
        int dp[] = new int[n];

        dp[0] = 0;

        for(int i=1;  i<n; i++){
            int jump = Integer.MAX_VALUE;
            
            for(int j=1; j<=k; j++){
                jump = Math.min(jump, dp[n-j] + Math.abs(height[n] - height[n-j]));
            }
            
            dp[i] = jump;
        }

        return dp[n-1];
    }
    
    public static void main(String args[]){
        int n = 4;
        int height[] = {10,20,30,10};
        int k = 2;

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println("Minimum energy required to reach nth stair (Recursion): " + minEnergy_rec(n-1, height, k));

        System.out.println("Minimum energy required to reach nth stair (Memoization): " + minEnergy_memo(n-1, height, dp, k));

        System.out.println("Minimum energy required to reach nth stair (Tabulation): " + minEnergy_tab(n-1, height, k)); // cannot be space optimized further
    }
}
