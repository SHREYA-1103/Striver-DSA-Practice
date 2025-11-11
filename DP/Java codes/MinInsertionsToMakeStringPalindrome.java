// ---------------------------------- Ques ------------------------------
// Given a string s, find the minimum number of insertions required 
// to make the string a palindrome.
// ----------------------------------------------------------------------

public class MinInsertionsToMakeStringPalindrome {

    // optimal - O(n^2), O(n^2)
    public static int minInsertions_tab(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lps = dp[n][n];
        return n - lps;
    }

    // optimal - O(n^2), O(n)
    public static int minInsertions_so(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int prev[] = new int[n + 1];
        int curr[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr.clone();
        }

        int lps = prev[n];
        return n - lps;
    }

    public static void main(String args[]) {
        String s = "mbadm";

        System.out.println(minInsertions_tab(s));
        System.out.println(minInsertions_so(s));
    }
}
