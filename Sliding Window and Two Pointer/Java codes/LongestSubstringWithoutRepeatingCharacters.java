import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    // optimal - O(n), O(1)
    public static int maxLength(String s){
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        int max = 0;

        while(r < n){
            char c = s.charAt(r);
            
            if(map.containsKey(c)){
                l = Math.max(l, map.get(c)+1);
            }
            
            map.put(c, r);
            max = Math.max(max, r-l+1);
            r++;
        }

        return max;
    }
    
    public static void main(String args[]){
        String s = "cadbzabcd";

        System.out.println(maxLength(s));
    }
}
