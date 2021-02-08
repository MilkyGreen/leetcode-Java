package p200.p148;

/**
 * //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * //
 * // 进阶：
 * //
 * //
 * // 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：head = [4,2,1,3]
 * //输出：[1,2,3,4]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：head = [-1,5,3,4,0]
 * //输出：[-1,0,3,4,5]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：head = []
 * //输出：[]
 * //
 */
public class Solution {

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        // 将链表分为两段
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next; // 后半段
        slow.next = null; // 前半段

        // 分别排序两段
        ListNode l = sortList(head);
        ListNode r = sortList(right);
        return merge(l, r); // 合并排序一下两段有序链表
    }

    /**
     * 并归排序
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode left,ListNode right){

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        ListNode head = new ListNode(-1); // 虚拟的头，这样不用总是判断空
        ListNode p = head; // 已排序链表结尾
        ListNode leftNode = left;
        ListNode rightNode = right;
        while (leftNode != null && rightNode != null){ // 每次取两个链表头中较小的一个，组成新链表，直到一个或两个为空
            if(leftNode .val < rightNode.val){
                p.next = leftNode;
                leftNode = leftNode.next;
            }else {
                p.next = rightNode;
                rightNode = rightNode.next;
            }
            p = p.next;
        }
        // 把空的放到后面
        if(leftNode == null){
            p.next = rightNode;
        }
        if(rightNode == null){
            p.next = leftNode;
        }
        return head.next;
    }








    public ListNode quicksortList(ListNode head) {
        if(head==null||head.next==null) return head;
        // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        return quickSort(newHead,null);
    }
    // 带头结点的链表快速排序
    private ListNode quickSort(ListNode head,ListNode end){
        if (head==end||head.next==end||head.next.next==end) return head;
        // 将小于划分点的值存储在临时链表中
        ListNode tmpHead=new ListNode(-1);
        // partition为划分点，p为链表指针，tp为临时链表指针
        ListNode partition=head.next,p=partition,tp=tmpHead;
        // 将小于划分点的结点放到临时链表中
        while (p.next!=end){
            if (p.next.val<partition.val){
                tp.next=p.next;
                tp=tp.next;
                p.next=p.next.next;
            }else {
                p=p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next=head.next;
        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
        head.next=tmpHead.next;
        quickSort(head,partition);
        quickSort(partition,end);
        // 题目要求不带头节点，返回结果时去除
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}