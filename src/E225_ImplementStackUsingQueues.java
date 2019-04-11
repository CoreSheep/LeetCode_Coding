import javax.management.QueryEval;
import java.util.*;

public class E225_ImplementStackUsingQueues {
    /** Initialize your data structure here. */
   private Queue<Integer> queue = new LinkedList<>();


    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i = 1; i < queue.size(); i++)
            queue.add(queue.remove());
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args){
        E225_ImplementStackUsingQueues myStack =
                new E225_ImplementStackUsingQueues();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
    }
}
