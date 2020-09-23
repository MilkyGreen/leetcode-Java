package p300.p206;

/**
 * 翻转单链表
 * <p>
 */
public class Solution {

    /**
     * 看来的思路：递归牛逼啊。。。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        // 空或者只剩一个节点，返回。其实最终返回的是原始链表的最后一个节点
        if(head == null || head.next == null){
            return head;
        }

        // 翻转除了头节点之后的链表（先不要往递归里跟，假设就是能翻转）。返回的是末尾节点
        ListNode last = reverseList(head.next);

        // 现在头节点之后的链表已经翻转过了，把头节点放在最后就行了。
        // 新链表的最后是原来的第二个节点，即head.next，在它后面接上head
        head.next.next = head;

        // 头节点现在成为未节点，next置为null
        head.next = null;

        // 返回原来的未节点，即翻转后的新头节点
        return last;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}