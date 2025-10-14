import java.util.*;

public class CountSubstringsWithAllThreeCharacters {

    // optimal - O(n), O(n)
    public static int countSubstrings(String s){
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        int count = 0;

        while(r < n){
            char c = s.charAt(r);
            
            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.size() == 3){
                count += n-r;
                int freq = map.get(s.charAt(l));
                if(freq > 1){
                    map.put(s.charAt(l), freq - 1);
                }
                else{
                    map.remove(s.charAt(l));
                }
                l++;
            }

            r++;
        }
        
        return count;
    }
    
    public static void main(String args[]){
        String s = "bbacba";

        System.out.println(countSubstrings(s));
    }
}
