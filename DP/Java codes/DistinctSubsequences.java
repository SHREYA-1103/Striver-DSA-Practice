// ---------------------------------- Ques ------------------------------
// Given two strings s and t, return the number of distinct subsequences of s which equals t. A subsequence is obtained by deleting some characters (can be none) from s without changing the relative order of the remaining characters.
// ----------------------------------------------------------------------

public class DistinctSubsequences {

    // optimal - O(n*m), O(n*m)
    public static int numDistinct_tab(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // Empty string t can always be formed
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    // optimal - O(n*m), O(m)
    public static int numDistinct_so(String s, String t) {
        int n = s.length();
        int m = t.length();
        int prev[] = new int[m + 1];
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int curr[] = new int[m + 1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr.clone();
        }

        return prev[m];
    }

    public static void main(String args[]) {
        String s = "babgbag";
        String t = "bag";

        System.out.println(numDistinct_tab(s, t));
        System.out.println(numDistinct_so(s, t));
    }
}
