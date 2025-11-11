// ---------------------------------- Ques ------------------------------
// Given two strings s1 and s2, print the Longest Common Subsequence (LCS).
// A subsequence is a sequence that appears in the same relative order but not necessarily contiguous.
// ----------------------------------------------------------------------

public class PrintLCS {

    // Optimal - O(mn), O(mn)
    public static String lcs_tab(String s1, String s2) {
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

        int i = n, j = m;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

    // For printing the LCS, full DP table is required for reconstruction, hence space optimization is not applicable for the printing version.

    public static void main(String args[]) {
        String s1 = "abcde";
        String s2 = "ace";

        System.out.println(lcs_tab(s1, s2));
    }
}