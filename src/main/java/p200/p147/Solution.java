package p200.p147;

//对链表进行插入排序。
//
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//
//
// 插入排序算法：
//
//
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 重复直到所有输入数据插入完为止。
//
//
//
//
// 示例 1：
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
//
// 示例 2：
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
// Related Topics 排序 链表
// 👍 351 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {

        if(head == null){
            return null;
        }
        // 待排序元素
        ListNode unSort = head.next;
        ListNode sortStart = head;// 已经排好的第一个元素
        ListNode sortEnd = head;// 已经排好的最后一个元素
        while (unSort != null){
            if(unSort.val >= sortEnd.val){ // 如果比已排序的最大还要大，直接排在后面。
                // 跟在end后面即可
                sortEnd.next = unSort;
                sortEnd = unSort;
            }else {
                sortEnd.next = unSort.next; // 先把待处理元素移除掉
                ListNode node = sortStart;// 要跟unsort比较的元素
                ListNode pre = null; // 比较元素的前一个元素
                while (node != sortEnd.next && node.val < unSort.val){ // 遍历已经排序的链表，依次比较
                    if(pre!=null){
                        pre = pre.next;
                    }else {
                        pre = node;
                    }
                    node = node.next;
                }
                // 此时pre<unsort<node，或者是最大的值，需要把unsort放到pre后面
                if(pre != null){
                    unSort.next = pre.next;
                    pre.next = unSort;
                    if(pre == sortEnd){ // 排在了最后，更新一下end节点
                        sortEnd = unSort;
                    }
                }else {
                    unSort.next = sortStart;
                    sortStart = unSort; // unsort是最小的节点，放在最前面
                }
            }
            unSort = sortEnd.next;
        }
        return sortStart;
    }

    public static void main(String[] args){
        // 输入: 4->2->1->3
        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);
        ListNode three = new ListNode(3);
        four.next = two;
        two.next = one;
        one.next = three;
        new Solution().insertionSortList(four);
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