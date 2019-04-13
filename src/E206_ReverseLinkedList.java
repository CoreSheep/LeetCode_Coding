public class E206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = new ListNode(-1);
        ListNode cur;
        if(head == null || head.next == null)
            return head;
        else{
            ListNode pre = head;
            cur = pre.next;
            newhead.next = null;
            while (cur != null){
                pre.next = newhead.next;
                newhead.next = pre;
                pre = cur;
                cur = cur.next;
            }
            pre.next = newhead.next;
            newhead.next = pre;
            return newhead.next;
        }
    }
}
