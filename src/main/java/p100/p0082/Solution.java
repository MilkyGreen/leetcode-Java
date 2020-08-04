package p100.p0082;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class Solution {

    /**
     * 思路：遍历，遇到重复的跳过即可。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode currNode = head;
        while (currNode.next != null){
            ListNode next = currNode.next;
            if(currNode.val == next.val){
                currNode.next = next.next; // 注意跳过之后继续从currNode判断，后面还有可能重复
            }else {
                currNode = next; // 继续下一个判断
            }
        }
        return head;
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
