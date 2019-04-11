/**
 * You're now a baseball game point recorder.
 *
 * Given a list of strings, each string can be one of the 4 following types:
 *
 * Integer (one round's score): Directly represents the number of points you
 * get in this round.
 * "+" (one round's score): Represents that the points you get in this round
 * are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round
 * are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid
 * round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round
 * before and the round after.
 *
 * You need to return the sum of the points you could get in all the rounds.
 */

import com.sun.deploy.panel.ITreeNode;
import com.sun.prism.shader.Solid_TextureFirstPassLCD_AlphaTest_Loader;

import java.net.SocketTimeoutException;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.Stack;

/**
 * Example 1:
 * Input: ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3: You could get 10 points (the round 2's data has been removed).
 * The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 */
public class E682_BaseBallGame {
    public static int calPoints(String[] ops){
        Stack<Integer> numStack = new Stack<>();
        String op;
        for(int i = 0; i < ops.length; i++){
            op = ops[i];
            if(op.matches("-?\\d+"))
                numStack.push(Integer.parseInt(op));

            //cut off the point in last round
            else if(op.equals("C") || op.equals("c"))
                numStack.pop();
            //double the point in last round
            else if(op.equals("D") || op.equals("d")){
                int top = numStack.peek();
                numStack.push((top << 1));
            }
            //add the last two round numbers
            else if(op.equals("+")){
                int top = numStack.pop();
                int stop = numStack.peek();
                numStack.push(top);
                numStack.push(top + stop);
            }
            //go cycling if not reach the end
            else
                continue;
        }
        int totalPoints = 0;
        Iterator<Integer> iterator = numStack.iterator();
        while(iterator.hasNext()){
            totalPoints += iterator.next();
        }
        return totalPoints;

    }

    public static void main(String[] args){
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));

    }

}
