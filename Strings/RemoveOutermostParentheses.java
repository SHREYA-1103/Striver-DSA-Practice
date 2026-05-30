
public class RemoveOutermostParentheses {

    // optimal - O(n), O(1)
    public static String removeOuterParentheses(String s){
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int open = 0;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '('){
                if(open > 0) res.append(c);
                open++;
            }
            else{
                open--;
                if(open>0) res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String args[]){
        String s = "()(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
    
}
