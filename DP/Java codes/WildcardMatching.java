// ---------------------------------- Ques ------------------------------
// Given an input string s and a pattern p, implement wildcard pattern matching 
// with support for '?' and '*'.
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// Return true if the pattern matches the entire string, otherwise false.
// ----------------------------------------------------------------------

public class WildcardMatching {

    // optimal - O(n*m), O(n*m)
    public static boolean isMatch_tab(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    // optimal - O(n*m), O(m)
    public static boolean isMatch_so(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean prev[] = new boolean[m + 1];
        boolean curr[] = new boolean[m + 1];

        prev[0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') prev[j] = prev[j - 1];
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = false;
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            prev = curr.clone();
        }

        return prev[m];
    }

    public static void main(String args[]) {
        String s = "abcde";
        String p = "a*?e";

        System.out.println(isMatch_tab(s, p));
        System.out.println(isMatch_so(s, p));
    }
}
