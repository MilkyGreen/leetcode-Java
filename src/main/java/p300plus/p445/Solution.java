package p300plus.p445;

public class Solution {
    // 先反转，再按照两数之和的方法来做，最后答案再反转一下
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int bo = 0;
        while(l1 != null && l2 != null){
            int n = l1.val + l2.val + bo;
            bo = n / 10;
            n %= 10;
            node.next = new ListNode(n);
            node = node.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode last = l1 != null ? l1 : l2;

        while(last != null){
            int n = last.val + bo;
            bo = n / 10;
            n %= 10;
            node.next = new ListNode(n);
            node = node.next;
            last = last.next;
        }
        // 注意最后一个可能的进位
        if(bo == 1){
            node.next = new ListNode(1);
            node = node.next;
        }

        return reverse(dummy.next);
    }

    // 反转链表
    ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
