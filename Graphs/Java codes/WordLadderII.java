import java.util.*;

public class WordLadderII {

    public static List<List<String>> possibleSeq(String initialWord, String targetWord, String wordList[]){
        List<List<String>> res  = new ArrayList<>();
        
        Set<String> set = new HashSet<>();
        
        set.addAll(Arrays.asList(wordList));

        if (!set.contains(targetWord)) {
            return res;
        }
        
        Queue<List<String>> q = new LinkedList<>();
        List<String> l = new ArrayList<>();
        l.add(initialWord);
        q.add(l);

        boolean found = false;
        Set<String> usedThisLevel = new HashSet<>();

        while(!q.isEmpty() && !found){
            int size = q.size();
            usedThisLevel.clear();
            
            for(int s=0; s<size; s++){
                List<String> path = q.remove();
                String word = path.get(path.size()-1);

                if (word.equals(targetWord)) {
                    found = true;
                    res.add(path);
                }

                if(found) continue;

                for(int i=0; i<word.length(); i++){
                    for(int j=0; j<26; j++){
                        char ch = (char)('a'+j);
                        String newWord = word.substring(0,i)+ch+word.substring(i+1,word.length());
                        if(set.contains(newWord)){
                            usedThisLevel.add(newWord);
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);
                            q.add(newPath);
                        }
                    }
                }
            }

            set.removeAll(usedThisLevel);
        }

        return res;
    }
    
    public static void main(String args[]){
        String initialWord = "hit";
        String targetWord = "cog";
        
        String wordList[] = {"hot", "dot", "dog", "lot", "log", "cog"};

        List<List<String>> allSeq = possibleSeq(initialWord, targetWord, wordList);
        
        for(List<String> list: allSeq){
            System.out.println(list);
        }
    }
}
