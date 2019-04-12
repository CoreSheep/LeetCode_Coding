import java.util.Stack;

public class M921_MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int addnum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(ch){
                case '(': stack.push(ch); break;
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        addnum += 1;
                    break;
                default:
                    System.out.println("Invalid Parentheses");
            }
        }
        return addnum + stack.size();
    }

    public static void main(String[] args){
        String s = "(((";
        System.out.println(minAddToMakeValid(s));
    }

}
