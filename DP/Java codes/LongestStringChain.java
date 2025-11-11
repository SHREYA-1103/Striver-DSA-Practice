// ---------------------------------- Ques ------------------------------
// You are given an array of words where each word consists of lowercase letters.
// A word A is a predecessor of word B if and only if you can insert exactly one letter anywhere in A 
// without changing the order of the other characters to make it equal to B.
// Return the length of the longest possible word chain with words chosen from the given list.
// ----------------------------------------------------------------------

import java.util.*;

public class LongestStringChain {

    // optimal - O(n^2 * l), O(n)
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (String word : words) {
            int currLen = 1;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev)) {
                    currLen = Math.max(currLen, dp.get(prev) + 1);
                }
            }
            dp.put(word, currLen);
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }

    public static void main(String args[]) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestStrChain(words));
    }
}
