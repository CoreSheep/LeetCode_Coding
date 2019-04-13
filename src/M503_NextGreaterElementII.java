import java.util.Arrays;
import java.util.Stack;

public class M503_NextGreaterElementII {
    public static int[] nextGreaterElements(int[] A) {
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        //We need to loop twice to iterate circularly
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];
            stack.push(i % n);
        }
        return res;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 1};
        int[] res = nextGreaterElements(a);
        for(int e : res)
            System.out.print(e + "\n");
    }
}
