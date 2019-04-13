import java.util.ArrayList;
import java.util.Stack;
import java.util.Timer;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode create(int[] input){
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for(int i : input){
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }

    public static void traverse(ListNode head){
        ListNode p = head.next;
        while (p != null){
            System.out.println(p.val + "\t");
        }
    }
}

public class M1019_NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }
}
