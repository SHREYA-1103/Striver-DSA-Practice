// ---------------------------------- Ques ------------------------------
// Given two strings word1 and word2, return the minimum number of operations required 
// to convert word1 into word2. 
// The allowed operations are insertion, deletion, and replacement of a character.
// ----------------------------------------------------------------------

public class EditDistance {

    // optimal - O(n*m), O(n*m)
    public static int editDistance_tab(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], 
                                    Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }

    // optimal - O(n*m), O(m)
    public static int editDistance_so(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];

        for (int j = 0; j <= m; j++) prev[j] = j;

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
                }
            }
            prev = curr.clone();
        }

        return prev[m];
    }

    public static void main(String args[]) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(editDistance_tab(word1, word2));
        System.out.println(editDistance_so(word1, word2));
    }
}