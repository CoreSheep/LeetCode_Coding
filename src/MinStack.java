import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Iterator;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;

    public MinStack(){
        stack = new Stack<Integer>();
    }
    public int getMin(){
        int min = Integer.MAX_VALUE;
        for(Integer integer : stack){
            if(integer < min)
                min = integer;
        }
        return min;
    }
    public void push(int x){
        stack.push(x);
    }

    public int top(){
        return stack.peek();
    }

    public int pop(){
        return stack.pop();
    }
}
