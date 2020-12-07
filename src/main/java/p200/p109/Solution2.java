package p200.p109;

import java.util.List;

/**
 * //给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * * //
 * * // 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * * //
 * * // 示例:
 * * //
 * * // 给定的有序链表： [-10, -3, 0, 5, 9],
 * * //
 * * //一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * * //
 * * //      0
 * * //     / \
 * * //   -3   9
 * * //   /   /
 * * // -10  5
 * * //
 */
public class Solution2 {

    /**
     * 看来的思路：每次找出单链表的中间元素作为根节点，并以此分割该链表为左右子树，递归处理
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return toTreeNode(head, null);
    }

    private TreeNode toTreeNode(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode midNode = getMidNode(left, right);
        TreeNode treeNode = new TreeNode(midNode.val);
        treeNode.left = toTreeNode(left, midNode); // 由于单链表无法取上一个元素，所以right并不包含在链表中
        treeNode.right = toTreeNode(midNode.next, right);
        return treeNode;
    }

    /**
     * 取一段链表的中间元素，right是不包含在链表内的。
     *
     * @param left  链表开始位置
     * @param right 链表结束位置后面一个元素
     * @return
     */
    private ListNode getMidNode(ListNode left, ListNode right) {
        ListNode fast = left; // 快指针
        ListNode slow = left; // 慢指针
        // 快指针走到了链表最后一个元素或者链表外一个元素，慢指针这时就在中间。
        // 链表元素为偶数的时候，快指针一次走两步，最终会走到链表外元素。奇数最终会走到最后一个元素。
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next; // 快指针每次走两步
            slow = slow.next; // 慢指针走一步
        }
        return slow;
    }
}


