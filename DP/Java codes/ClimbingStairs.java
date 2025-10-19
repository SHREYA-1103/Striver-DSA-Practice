import java.util.*;

public class ClimbingStairs {

    // Bruteforce (Recursion) - O(2^n), O(2^n)
    public static int ways_rec(int n){
        if(n <= 2){
            return n;
        }

        return ways_rec(n-1) + ways_rec(n-2);
    }

    // Better (DP memoization) - O(n), O(2n)
    public static int ways_memo(int n, int dp[]){
        if(n <= 2){
            return dp[n] = n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = ways_memo(n-1, dp) + ways_memo(n-2, dp);
    }

    // Optimal1 (DP tabulation) - O(n), O(n)
    public static int ways_tab(int n){
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;  i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // Optimal2 (tabulation space optimised) - O(n), O(1)
    public static int ways_so(int n){
        int a = 1;
        int b = 2;

        for(int i=3;  i<n+1; i++){
            int c = a+b;
            a = b;
            b = c;                
        }

        return b;
    }
    
    public static void main(String args[]){
        int n = 5;

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println("No. of distinct ways to reach nth stair (Recursion): " + ways_rec(n));

        System.out.println("No. of distinct ways to reach nth stair (Memoization): " + ways_memo(n, dp));

        System.out.println("No. of distinct ways to reach nth stair (Tabulation): " + ways_tab(n));

        System.out.println("No. of distinct ways to reach nth stair (Tabulation space optimized): " + ways_so(n));
    }
}
