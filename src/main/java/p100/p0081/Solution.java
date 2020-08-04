package p100.p0081;

/**
 * <p>
 *     给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * //
 * // 示例 1:
 * //
 * // 输入: 1->2->3->3->4->4->5
 * //输出: 1->2->5
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: 1->1->1->2->3
 * //输出: 2->3
 */
public class Solution {

    /**
     * 思路：遍历链表，记录最近一个不重复的节点preNonDupNode，不断更新preNonDupNode直到遇到重复节点，遍历完重复节点后，跳过中间重复的直接指向重复的next。
     * 执行结果：速度 击败92% Java提交，噢耶。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }

        // 虚拟头节点
        ListNode dump = new ListNode(0);
        dump.next = head;
        // 最近一个不重复节点
        ListNode preNonDupNode = dump;

        ListNode currNode = head;
        // 当前是否有重复节点未处理
        boolean currHasDup = false;
        while (currNode.next != null){

            if(currNode.val != currNode.next.val){
                // 两个节点不重复且前面有重复节点
                if(currHasDup){
                    currHasDup = false;
                    // 上个不重复节点指向下个不重复节点，即把中间的重复节点跳过
                    preNonDupNode.next = currNode.next;
                }else {
                    // 当前没有未处理重复节点，更新preNonDupNode即可
                    preNonDupNode = currNode;
                }
            }else {
                currHasDup = true;
            }
            currNode = currNode.next;
        }

        // 如果列表最后有没处理的重复节点，则全部删掉
        if(currHasDup){
            preNonDupNode.next = null;
        }

        return dump.next;
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
