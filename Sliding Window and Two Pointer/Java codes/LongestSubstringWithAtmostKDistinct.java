public class LongestSubstringWithAtmostKDistinct {
    
    // bruteforce - O(n^2), O(!)
    public static int findLength_brute(String s, int k){
        int n = s.length();

        int maxLength = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int freq[] = new int[26];
            int distinct = 0;
            int j = i;
            while(j < n && distinct <= k){
                char c = s.charAt(j);
                if(freq[c-'a'] == 0){
                    distinct++;
                }
                freq[c-'a']++;
                maxLength = Math.max(maxLength, j-i);
                j++;
            }
        }

        return maxLength;
    }

    public static void main(String args[]){
        String s = "aaabbccd";
        int k = 2;

        System.out.println(findLength_brute(s, k));
    }
}
