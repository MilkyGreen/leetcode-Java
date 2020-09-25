package p100.p0092;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class Solution {

    /**
     * 思路：递归牛逼啊。。。
     * 详细解答：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(m == 1){ // m=1 相当于反转n个元素
            return reverseN(head,n);
        }

        // 向后遍历，直到m=1。 其实是找到m位置的元素，当成head传入方法，n同时要减。最后就成了reverseN问题。
        head.next = reverseBetween(head.next,m-1,n-1);

        // 返回head，因为头没变。
        return head;
    }

    // 反转区间后面的元素
    ListNode backNode = null;

    /**
     * 翻转前n个节点
     * @param head
     * @param n
     * @return
     */
    private ListNode reverseN(ListNode head, int n){
        if(n == 1){ // n=1 ，反转一个元素，就是它自己
            backNode = head.next;  // 记录一下后面的元素，最后要拼起来
            return head;
        }

        // 先反转后面的链表
        ListNode last = reverseN(head.next, n - 1);

        // 将头节点放到最后
        head.next.next = head;

        // 头节点后面跟之前的后继节点
        head.next = backNode;

        // 返回原来last，即新的head
        return last;
    }
}

class ListNode {
     int val;
     ListNode next;
    ListNode(int x) { val = x; }
}
