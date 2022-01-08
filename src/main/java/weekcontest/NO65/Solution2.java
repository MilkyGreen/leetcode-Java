package weekcontest.NO65;

import java.util.Stack;

/**
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println();
    }


    public int pairSum(ListNode head) {
        int ret = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        Stack<ListNode> stack = new Stack<>();
        while (fast.next != null){
            slow = slow.next;
            stack.push(slow);
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        while (mid != null){
            ret = Math.max(ret,mid.val + stack.pop().val);
            mid = mid.next;
        }
        return ret;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
