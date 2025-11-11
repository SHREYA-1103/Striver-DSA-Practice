// ---------------------------------- Ques ------------------------------
// Given a string s, find the length of the longest palindromic subsequence in it.
// Palindromic sequence is the one which reads the same from start and end and subsequence implies it need not be contiguous.
// ----------------------------------------------------------------------

public class LongestPalindromicSubsequence {

    // optimal - O(n^2), O(n^2)
    public static int longestPalindromicSubsequence_tab(String s) {
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

        return dp[n][n];
    }

    // optimal - O(n^2), O(n)
    public static int longestPalindromicSubsequence_so(String s) {
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

        return prev[n];
    }

    public static void main(String args[]) {
        String s = "bbabcbcab";

        System.out.println(longestPalindromicSubsequence_tab(s));
        System.out.println(longestPalindromicSubsequence_so(s));
    }
}
