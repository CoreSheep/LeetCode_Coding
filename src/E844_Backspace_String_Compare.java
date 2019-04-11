import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed
 * into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 */

public class E844_Backspace_String_Compare {
    public static boolean backspaceCompare(String S, String T) {
        //two stacks for two strings
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) != '#')
                s1.push(S.charAt(i));
            else{
                if(!s1.empty())
                    s1.pop();
            }
        }
        for(int i = 0; i < T.length(); i++){
            if(T.charAt(i) != '#')
                s2.push(T.charAt(i));
            else{
                if(!s2.empty())
                    s2.pop();
            }
        }
        if(s1.size() != s2.size()) return false;
        while (!s1.empty() || !s2.empty()){
            if(!s1.peek().equals(s2.peek()))
                return false;
            s1.pop();
            s2.pop();
        }
        return true;
    }
    public static void main(String[] args){
        String S = "ab#c", T = "ad#c";
        String S1 = "xywrrmp", T1 ="xywrrmu#p";
        System.out.println(backspaceCompare(S1, T1));
    }
}
