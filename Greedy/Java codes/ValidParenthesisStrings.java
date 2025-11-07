// -------------------------------- Ques --------------------------------
// Given a string composed of two kinds on parenthesis, '(' and ')' along with a character '*' which can be replaced as '(' or ')' or an empty character, find if the given string represents a string of valid parenthesis.
// ----------------------------------------------------------------------

public class ValidParenthesisStrings {

    // optimal - O(n), O(1)
    public static boolean isValid(String s){
        int min = 0;
        int max = 0;

        for(char c: s.toCharArray()){
            switch (c) {
                case ')' -> {
                    min -= 1;
                    max -= 1;
                }
                case '(' -> {
                    min += 1;
                    max += 1;
                }
                default -> {
                    min -= 1;
                    max += 1;
                }
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }

        return min == 0;
    }
    
    public static void main(String args[]){
        String s = "())";

        System.out.println(isValid(s));
    }
}
