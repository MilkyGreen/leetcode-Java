package p100.p0024;

/**
 * Created by simon on 2020/2/20.
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }



}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}