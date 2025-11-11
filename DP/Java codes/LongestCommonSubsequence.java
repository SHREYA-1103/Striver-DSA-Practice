// ---------------------------------- Ques ------------------------------
// Given two strings s1 and s2, find the length of their Longest Common Subsequence (LCS).
// A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
// ----------------------------------------------------------------------

public class LongestCommonSubsequence {

    // optimal - O(mn), O(mn)
    public static int lcs_tab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    // optimal - O(mn), O(m)
    public static int lcs_so(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr.clone();
        }

        return prev[m];
    }

    public static void main(String args[]) {
        String s1 = "abcde";
        String s2 = "ace";

        System.out.println(lcs_tab(s1, s2));
        
        System.out.println(lcs_so(s1, s2));
    }
}
