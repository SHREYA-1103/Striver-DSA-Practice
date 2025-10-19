import java.util.*;

public class FrogJumps {

    // Bruteforce (Recursion) - O(2^n), O(2^n)
    public static int minEnergy_rec(int n, int height[]){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return Math.abs(height[1] - height[0]);
        }

        int jump1 = minEnergy_rec(n-2, height) + Math.abs(height[n] - height[n-2]);
        int jump2 = minEnergy_rec(n-1, height) + Math.abs(height[n] - height[n-1]);
        
        return Math.min(jump1, jump2);
    }

    // Better (DP memoization) - O(n), O(2n)
    public static int minEnergy_memo(int n, int height[], int dp[]){
        if(n == 0){
            return dp[n] = n;
        }

        if(n == 1){
            return dp[n] = height[1] - height[0];
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int jump1 = minEnergy_memo(n-2, height, dp) + Math.abs(height[n] - height[n-2]);
        int jump2 = minEnergy_memo(n-1, height, dp) + Math.abs(height[n] - height[n-1]);
        
        return dp[n] = Math.min(jump1, jump2);
    }

    // Optimal1 (DP tabulation) - O(n), O(n)
    public static int minEnergy_tab(int n, int height[]){
        int dp[] = new int[n];

        dp[0] = 0;
        dp[1] = height[1] - height[0];

        for(int i=2;  i<n; i++){
            dp[i] = Math.min(dp[i-1] + Math.abs(height[i] - height[i-1]),  dp[i-2] + Math.abs(height[i] - height[i-2]));
        }

        return dp[n-1];
    }

    // Optimal2 (tabulation space optimized) - O(n), O(1)
    public static int minEnergy_so(int n, int height[]){
        int a = 0;
        int b = height[1] - height[0];

        for(int i=2;  i<n; i++){
            int c = Math.min(b + Math.abs(height[i] - height[i-1]),  a + Math.abs(height[i] - height[i-2]));
            a = b;
            b = c;
        }

        return b;
    }
    
    public static void main(String args[]){
        int n = 4;
        int height[] = {10,20,30,10};

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println("Minimum energy required to reach nth stair (Recursion): " + minEnergy_rec(n-1, height));

        System.out.println("Minimum energy required to reach nth stair (Memoization): " + minEnergy_memo(n-1, height, dp));

        System.out.println("Minimum energy required to reach nth stair (Tabulation): " + minEnergy_tab(n-1, height));

        System.out.println("Minimum energy required to reach nth stair (Tabulation space optimised): " + minEnergy_so(n-1, height));
    }
}
