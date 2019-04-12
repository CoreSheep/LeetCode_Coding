import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Stack;

public class E20_ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char ch : s.toCharArray()){
            switch (ch){
                case '(':
                case '{':
                case '[': stack.push(ch); break;
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String s = ")";
        System.out.println(isValid(s));

    }
}
