import com.sun.org.apache.bcel.internal.generic.LNEG;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

public class E21_MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = l1, q = l2, tail = head;
        while (p != null && q != null){
            if(p.val <= q.val){
                tail.next  = p;
                p = p.next;
                tail = tail.next;
            } else{
                tail.next = q;
                q = q.next;
                tail = tail.next;
            }
        }
        if(p != null)
            tail.next = p;
        if(q != null)
            tail.next = q;
        return head.next;
    }

    public static void main(String[] args){
        int[] l1 = {1, 2, 4};
        int[] l2 = {1, 3, 4};

        ListNode list1 = ListNode.create(l1);
        ListNode list2 = ListNode.create(l2);

        ListNode head = mergeTwoLists(list1.next, list2.next);
        while (head != null) {
            System.out.println(head.val + "\t");
            head = head.next;
        }


    }
}
