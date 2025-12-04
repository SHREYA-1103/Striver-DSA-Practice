import java.util.*;

public class WordLadderI {

    public static class Pair{
        String word;
        int seq;

        public Pair(String w, int s){
            this.word = w;
            this.seq = s;
        }
    }

    public static int minSteps(String initialWord, String targetWord, String wordList[]){
        Set<String> set = new HashSet<>();
        
        set.addAll(Arrays.asList(wordList));

        if (!set.contains(targetWord)) {
            return -1;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(initialWord, 1));

        while(!q.isEmpty()){
            Pair p = q.remove();
            String word = p.word;
            int seq = p.seq;

            if (word.equals(targetWord)) {
                return seq;
            }
            for(int i=0; i<word.length(); i++){
                for(int j=0; j<26; j++){
                    char ch = (char)('a'+j);
                    String newWord = word.substring(0,i)+ch+word.substring(i+1,word.length());
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, seq+1));
                        set.remove(newWord);
                    }
                }
            }
        }

        return -1;
    }
    
    public static void main(String args[]){
        String initialWord = "hit";
        String targetWord = "cog";
        
        String wordList[] = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(minSteps(initialWord, targetWord, wordList));
    }
}
