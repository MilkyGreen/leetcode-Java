package p100.p0019;

/**
 * Created by simon on 2020/2/16.
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode second  = dummy,first = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (null != first){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}