package p100.p0061;

public class Solution2 {

    // 先从头遍历到尾，将尾连到头，形成一个环。顺便统计节点数量。
    // 后面的目的是要找到新的头，从那里把环断开就行了。
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        // 从头到尾遍历
        int n = 1;
        ListNode node = head;
        while(node.next != null){
            n++;
            node = node.next;
        }
        // 将尾连到头上，形成环
        ListNode end = node;
        end.next = head;

        // 计算要找的头节点位置。
        // 如果长度是3 移动1位和移动4位，效果其实是一样的，因此 k % n 是真正要移动的步数。
        // 我们只能从前往后找新的头节点，需要从头节点往后找，怎么找呢？
        // 如果移动1位，新头就是尾节点，如果移动2位，就是倒数第2个节点，如果移动3位...
        // 而从头节点的角度来说，找倒数第i个节点就是向后移动 n - i步，所以 step = n - k % n;
        int step = n - k % n;
        // 如果步数是0，不用移动。
        if(step == 0){
            end.next = null;
            return head;
        }

        ListNode pre = head;
        while(step > 1){
            step--;
            pre = pre.next;
        }
        // 找到了新头节点，打断一下环
        ListNode newHead = pre.next;
        pre.next = null;
        return newHead;

    }
    
}
