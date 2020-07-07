package p100.p0061;

/**
 * @author liyunmeng
 * @Description: 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 个人思路1（失败了）：定位到最后一个node，将其放到第一位，循环操作k次即可。 -> 此解法失败了，因为单向链表无法快速找到元素的上一个。。。
 * 个人思路2：必须直接定位到旋转过后的end上面。用双指针，快指针比慢指针提前k步，当快指针到end的时候，慢指针正好到倒数k个，
 * 又失败了，[1,2,3]  2000000000 这个case没过。。。
 * 个人思路3（成功，击败78%）：延续思路2，如果k大于链表长度，直接相除取余，对于长度为3的链表，移动4步和1步的效果是一样的。拿余数当做新的k
 * @Date 2020/4/28 14:07
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null){
            return head;
        }
        // 链表长度
        int l = 1;
        ListNode next = head;
        while (next.next != null){
            next = next.next;
            l++;
        }

        if(l == k){
            return head;
        }else if(l < k){
            k = k%l;
        }

        if(k == 0){
            return head;
        }

        int fastindex = 0;

        next = head;
        ListNode slownext = head;
        while (next.next != null){
            // 如果等于或者超过K次，慢指针开始从头移动
            if(fastindex >= k){
                /*// 判断k比链表还长的情况，再从头开始
                if(slownext.next == null){
                    slownext = head;
                }else{
                    slownext = slownext.next;
                }*/
                slownext = slownext.next;
            }
            // 快指针每次都移动
            fastindex++;
            // 判断k比链表还长的情况，再从头开始
            /*if(next.next == null){
                oldEnd = next;
                next = head;
            }else{
                next = next.next;
            }*/
            next = next.next;
        }
        ListNode oldEnd = next;

        ListNode newEnd = slownext;

        oldEnd.next = head;
        head = newEnd.next;
        newEnd.next = null;

        return head;
    }

    public static void main(String[] args){
        System.out.println(2000000000%3);
    }

}



class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}