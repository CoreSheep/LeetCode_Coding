import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

public class E876_MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode listNode = head;
        listNode = head.next;

        int len = 0;

        while (listNode != null){
            len++;
            listNode = listNode.next;
        }

        listNode = head;
        if(len % 2 == 0){
            for(int i = 0; i < len >> 1; i++){
                listNode = listNode.next;
            }
        } else{
            for(int i = 0; i <= len >> 1; i++){
                listNode = listNode.next;
            }

        }
        return listNode;
    }

    public ListNode better(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
