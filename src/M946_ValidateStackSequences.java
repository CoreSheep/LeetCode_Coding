import java.util.Stack;

public class M946_ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length && j < popped.length){
            stack.push(pushed[i++]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(push, pop));
    }
}
