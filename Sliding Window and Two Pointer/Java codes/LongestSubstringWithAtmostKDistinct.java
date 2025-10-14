import java.util.*;

public class LongestSubstringWithAtmostKDistinct {
    
    // bruteforce - O(n^2), O(!)
    public static int findLength_brute(String s, int k){
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int freq[] = new int[26];
            int distinct = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (freq[c - 'a'] == 0) distinct++;
                if (distinct > k) break;
                freq[c - 'a']++;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    // optimal - 
    public static int findLength_optimal(String s, int k){
        int n = s.length();

        int l = 0;
        int r = 0;

        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while(r < n){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);

            if(map.size() > k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }

            max = Math.max(max, r-l+1);
            r++;
        }

        return max;
    }

    public static void main(String args[]){
        String s = "aaabbccd";
        int k = 2;

        System.out.println(findLength_brute(s, k));

        System.out.println(findLength_optimal(s, k));
    }
}
