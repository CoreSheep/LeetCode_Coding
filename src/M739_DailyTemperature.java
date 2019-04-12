import com.sun.javafx.sg.prism.web.NGWebView;
import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.lang.reflect.Method;
import java.util.Stack;

public class M739_DailyTemperature {
    /**
     * method one is extremely easy to come up with, but time costs.
     * @param T
     * @return res
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for(int i = 0; i < T.length -1; i++){
            boolean hasWarmerDay = false;
            for(int j = i + 1; j < T.length; j++){
                if(T[i] < T[j]){
                    res[i] = j - i;
                    hasWarmerDay = true;
                    break;
                }
            }
            if(!hasWarmerDay)
                res[i] = 0;
        }
        res[T.length - 1] = 0;
        return res;
    }

    public static int[] solution2(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args){
        int[] temperature = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solution2(temperature);
        for( int i : res){
            System.out.print(i + "\t");
        }
    }
}
