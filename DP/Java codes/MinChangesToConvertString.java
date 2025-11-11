// ---------------------------------- Ques ------------------------------
// Given two strings s1 and s2, find the minimum number of insertions and deletions required to convert s1 into s2.
// ----------------------------------------------------------------------

public class MinChangesToConvertString {

    // optimal - O(n*m), O(n*m)
    public static int[] minOperations_tab(String s1, String s2) {
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
        int deletions = n - lcs;
        int insertions = m - lcs;

        return new int[]{insertions, deletions};
    }

    // optimal - O(n*m), O(m)
    public static int[] minOperations_so(String s1, String s2) {
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
        int deletions = n - lcs;
        int insertions = m - lcs;

        return new int[]{insertions, deletions};
    }

    public static void main(String args[]) {
        String s1 = "heap";
        String s2 = "pea";

        int ans1[] = minOperations_tab(s1, s2);
        System.out.println("Insertions: " + ans1[0] + ", Deletions: " + ans1[1]);

        int ans2[] = minOperations_so(s1, s2);
        System.out.println("Insertions: " + ans2[0] + ", Deletions: " + ans2[1]);
    }
}
