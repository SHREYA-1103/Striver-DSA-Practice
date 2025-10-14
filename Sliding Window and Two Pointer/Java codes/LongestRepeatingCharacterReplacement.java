
public class LongestRepeatingCharacterReplacement {

    // Optimal - O(n), O(26)
    public static int maxLength(String s, int k){
        int n = s.length();

        int l = 0;
        int r = 0;

        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLen = 0;

        while(r < n){
            char c = s.charAt(r);
            freq[c - 'a']++;

            maxFreq = Math.max(maxFreq, freq[c - 'a']);

            int len = r - l + 1;

            if(len - maxFreq > k){
                freq[s.charAt(l) - 'a']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
    
    public static void main(String args[]){
        String s = "aababba";
        int k = 2;

        System.out.println(maxLength(s, k));
    }
}
