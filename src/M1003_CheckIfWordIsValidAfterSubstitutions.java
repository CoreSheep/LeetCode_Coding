import java.util.Stack;

public class M1003_CheckIfWordIsValidAfterSubstitutions {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            switch(ch){
                case 'a':
                case 'b': stack.push(ch); break;
                case 'c':
                    if(!stack.isEmpty() && stack.peek() == 'b')
                        stack.pop();
                    else
                        return false;
                    if(!stack.isEmpty() && stack.peek() == 'a')
                        stack.pop();
                    else
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String test = "abababcc";
        System.out.println(isValid(test));
    }
}
