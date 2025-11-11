// ---------------------------------- Ques ------------------------------
// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return the minimum number of cuts needed for a palindrome partitioning of s.
// ----------------------------------------------------------------------

public class PalindromePartitioning {

    // optimal - O(n^2), O(n^2)
    public static int minCut(String s) {
        int n = s.length();
        boolean dpPalindrome[][] = new boolean[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                switch (gap) {
                    case 0:
                        dpPalindrome[i][j] = true;
                        break;
                    case 1:
                        dpPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                        break;
                    default:
                        dpPalindrome[i][j] = s.charAt(i) == s.charAt(j) && dpPalindrome[i + 1][j - 1];
                        break;
                }
            }
        }

        int dpCuts[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (dpPalindrome[0][i]) dpCuts[i] = 0;
            else {
                int minCuts = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (dpPalindrome[j + 1][i]) minCuts = Math.min(minCuts, dpCuts[j] + 1);
                }
                dpCuts[i] = minCuts;
            }
        }

        return dpCuts[n - 1];
    }

    public static void main(String args[]) {
        String s = "aab";
        System.out.println(minCut(s)); // Output: 1
    }
}
