// ---------------------------------- Ques ------------------------------
// Given two strings s1 and s2, find the length of the shortest common supersequence.
// The shortest common supersequence is the smallest string which has both s1 and s2 as subsequences.
// ----------------------------------------------------------------------

public class ShortestCommonSupersequence {

    // optimal - O(n*m), O(n*m)
    public static int shortestCommonSupersequence_tab(String s1, String s2) {
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

        int lcs = dp[n][m];
        return n + m - lcs;
    }

    // optimal - O(n*m), O(m)
    public static int shortestCommonSupersequence_so(String s1, String s2) {
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

        int lcs = prev[m];
        return n + m - lcs;
    }

    public static void main(String args[]) {
        String s1 = "brute";
        String s2 = "groot";

        System.out.println(shortestCommonSupersequence_tab(s1, s2));
        System.out.println(shortestCommonSupersequence_so(s1, s2));
    }
}
