// ---------------------------------- Ques ------------------------------
// Given two strings s1 and s2, find the length of the Longest Common Substring.
// A substring is a contiguous part of a string.
// ----------------------------------------------------------------------

public class LongestCommonSubstring {

    // optimal - O(mn), O(mn)
    public static int longestCommonSubstring_tab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }

    // optimal - O(mn), O(m)
    public static int longestCommonSubstring_so(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    maxLen = Math.max(maxLen, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr.clone();
        }

        return maxLen;
    }

    public static void main(String args[]) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        System.out.println(longestCommonSubstring_tab(s1, s2));
        
        System.out.println(longestCommonSubstring_so(s1, s2));  
    }
}
