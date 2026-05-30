import java.util.*;

public class ReverseSentence {

    // brute - O(n+k), O(k)
    public static void reverseSentence(String s){
        StringBuilder temp = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != ' '){
                temp.append(c);
            }
            else{
                words.add(temp.toString());
                temp = new StringBuilder();
            }
        }
        words.add(temp.toString());

        for(int i=0; i<words.size(); i++){
            System.out.print(words.get(words.size()-i-1) + " ");
        }
    }
    
    public static void main(String args[]){
        String s = "hello world";
        reverseSentence(s);
    }
}
