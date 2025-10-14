import java.util.*;

public class MinimumWindowSubstring {

    // optimal - O(2n + m), O(256)
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int required = tMap.size(); 
        int formed = 0;

        Map<Character, Integer> mp = new HashMap<>();
        int l = 0, r = 0;

        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            char c = s.charAt(r);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && mp.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                char lc = s.charAt(l);
                mp.put(lc, mp.get(lc) - 1);
                if (tMap.containsKey(lc) && mp.get(lc) < tMap.get(lc)) {
                    formed--;
                }
                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String args[]){
        String s = "ddaaabbca";
        String t = "abc";

        System.out.println(minWindow(s, t));
    }
}
