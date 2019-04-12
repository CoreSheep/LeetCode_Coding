import java.util.Currency;
import java.util.Stack;

public class M856_ScoreOfParentheses {
    public static int scoreOfParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(score);
                score = 0; //clear current layer level
            } else {
                //accumulate score with outer layer level
                score = stack.pop() + Math.max(score << 1, 1);
            }
        }
        return score;
    }

    public static void main(String[] args){
        String s = "((())())";
        System.out.println(scoreOfParentheses(s));
    }
}
