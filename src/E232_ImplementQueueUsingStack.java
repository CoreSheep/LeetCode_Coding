import com.sun.istack.internal.localization.NullLocalizable;

import java.time.temporal.Temporal;
import java.util.Stack;

public class E232_ImplementQueueUsingStack {
    /** Initialize your data structure here. */
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
       if(output.empty()){
           while (!input.empty()){
               output.push(input.pop());
           }
       }
       return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }

    public static void main(String[] args){
        E232_ImplementQueueUsingStack mystack =
                new E232_ImplementQueueUsingStack();
        mystack.push(1);
        mystack.push(2);
        System.out.println(mystack.peek());
        System.out.println(mystack.empty());
        System.out.println(mystack.pop());

    }

}
