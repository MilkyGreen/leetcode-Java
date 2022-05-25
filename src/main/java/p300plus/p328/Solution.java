package p300plus.p328;

public class Solution {
    // tips: 原地算法，不一定非要原地交换。链表对象是可以移动的，只要不创建新的链表对象即可。原地指的是内存地址的原地。
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode node = head;
        ListNode dummy = new ListNode();
        ListNode evens = dummy;
        ListNode pre = head;

        while(node != null && node.next != null){
            pre = node;
            node = node.next;
            ListNode even = node;
            node = node.next;
            pre.next = node;

            evens.next = even;
            evens = even;
            evens.next = null;
        }

        if(node == null){
            pre.next = dummy.next;
        }else{
            node.next = dummy.next;
        }
        return head;
    }
}
