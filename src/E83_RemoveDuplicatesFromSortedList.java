public class E83_RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        else{
            ListNode pre = head, cur = head.next;
            while (cur != null){
                if(cur.val == pre.val){
                    pre.next = cur.next;
                    cur = cur.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
        }
        return head;
    }
    public static void main(String[] args){
        int[] ints = {1, 1, 2, 3, 3};
        ListNode l1 = ListNode.create(ints);
        deleteDuplicates(l1.next);
    }
}
