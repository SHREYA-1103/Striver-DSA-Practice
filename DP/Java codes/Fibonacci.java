import java.util.*;

public class Fibonacci {

    // Bruteforce (Recursion) - O(2^n), O(2^n)
    public static int fib_rec(int n){
        if(n <= 1){
            return n;
        }

        return fib_rec(n-1) + fib_rec(n-2);
    }

    // Better (DP memoization) - O(n), O(2n)
    public static int fib_memo(int n, int dp[]){
        if(n <= 1){
            return dp[n] = n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = fib_memo(n-1, dp) + fib_memo(n-2, dp);
    }

    // Optimal1 (DP tabulation) - O(n), O(n)
    public static int fib_tab(int n){
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;  i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // optimal2 (tabulation space optimized) - O(n), O(1)
    public static int fib_so(int n){
        int a = 0;
        int b = 1;

        for(int i=02; i<n+1; i++){
            int c = a+b;
            a = b;
            b = c;
        }

        return b;

    }
    
    public static void main(String args[]){
        int n = 10;

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println("Fibonacci (Recursion): " + fib_rec(n));

        System.out.println("Fibonacci (Memoization): " + fib_memo(n, dp));

        System.out.println("Fibonacci (Tabulation): " + fib_tab(n));

        System.out.println("Fibonacci (Tabulation space optimized): " + fib_so(n));
    }
}
