package p200.p160;

//编写一个程序，找到两个单链表相交的起始节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
//
public class Solution {


    /**
     * 思路：如果两个链表长度一样，同时遍历，会在相交点相等，或者同时为null。
     * 如果长度不相等，就同时遍历 a+b 和 b+a。假设b比a长2个元素，a会先遍历完，这时将指针指向b的开头继续遍历。当b也遍历完的时候，指向a。
     * 这时，b已经又遍历的2个元素，两个指针就「对齐」了，继续往下遍历，如果相等就找到了，都为null说明没有相交。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) { // 两种情况跳出循环：找到交点和同时为null。同时为null分为两种情况，长度相等的话遍历第一遍就会退出，不相等第二遍会退出，因为下面的.next没判断是否为null
            pA = (pA == null) ? headB : pA.next; // 等于null，要指向b的头
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
