package p100.p0086;

/**
 * <p>
 * <p>
 *     //给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * //
 * //你应当保留两个分区中每个节点的初始相对位置。
 * //
 * //示例:
 * //
 * //输入: head = 1->4->3->2->5->2, x = 3
 * //输出: 1->2->2->4->3->5
 * //
 *
 * @version 1.0.0
 */
public class Solution {
    //思路：双指针，left、right指针同时遍历，left遇到大于等于x的节点停住，right继续，
    // 直到遇到小于x节点时，将right移动到left前面（因为要求「保留两个分区中每个节点的初始相对位置」，所以不能简单的交换值，需要移动链表）
    // 然后继续往下遍历，直到right到末尾
    // -> 时间击败100%Java，(ｖ＾＿＾)ｖ
    public ListNode partition(ListNode head, int x) {

        // 设置虚拟头节点，方便处理边界情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // left找大于等于x的值
        ListNode left = head;
        // right 找小于x的值
        ListNode right = null;
        // right前一个节点。由于是单向链表，需要记录两个pre节点辅助交换
        ListNode preRight = null;
        // left前节点
        ListNode preLeft = dummy;

        while (left != null){
            if(left.val >= x){ // left比目标大,停止遍历
                // 需要找right
                if(right == null){// 第一次给right赋值，取left的next
                    preRight = left;
                    right = left.next;
                }
                while (true){
                    if(right == null){
                        return dummy.next;
                    }
                    if(right.val < x){
                        // right遇到小值，需要把right移动到left前面
                        preLeft.next = right;
                        preRight.next = right.next;
                        right.next = left;

                        // 移动后left保持不变，preLeft往前移一位
                        preLeft = preLeft.next;
                        // right移动
                        right = preRight.next;
                        break;
                    }else {
                        preRight = right;
                        right = right.next;
                    }
                }
            }else {
                preLeft = left;
                left = left.next;
            }
        }
        return dummy.next;
    }

    //输入: head = 1->4->3->2->5->2, x = 3
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node22 = new ListNode(2);
        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node22;
        Solution solution = new Solution();
        solution.partition(node1, 3);

        solution.partition(new ListNode(1), 0);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}