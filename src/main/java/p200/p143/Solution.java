package p200.p143;

/**
 * //给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * //将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * //
 * // 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * //
 * // 示例 1:
 * //
 * // 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * //
 * // 示例 2:
 * //
 * // 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * // Related Topics 链表
 * // 👍 512 👎 0
 */
public class Solution {

    /**
     * 翻转
     * 12345
     * 1 5432
     *
     * 15 234
     *
     * 152 43
     *
     * 1524 3
     *
     * 15243
     *
     *
     * 12345  ——
     *
     * @param head
     */
    /**
     * 思路：每次取head，然后翻转后面的，再取头，翻转后的，取头。。。直到结束。->超时了。。。
     *
     * 新思路：先通过双指针找到链表中间位置，翻转后面一段。遍历两段，将后面的依次插入前面元素的间隙中。
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode fast = head,slow = head;
        // 找到链表中间
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        ListNode secHalf = slow.next; // 后半部分切割成独立链表
        slow.next = null;

        secHalf = reverse(secHalf); // 翻转后半段链表

        // 循环两个链表，将后半段依次插入前半段中间
        ListNode firstHalf = head;
        while (secHalf != null) { // 后半段长度小于等于前面
            ListNode oldNext = firstHalf.next; // 前半段原来的next
            ListNode secOldNext = secHalf.next; // 后半段原来的next

            firstHalf.next = secHalf; // next改为后半段next
            secHalf.next = oldNext;

            firstHalf = oldNext;
            secHalf = secOldNext;
        }
    }

    // 翻转链表
    private ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}