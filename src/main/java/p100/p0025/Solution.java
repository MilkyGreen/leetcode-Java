package p100.p0025;

import java.util.Stack;

/**
 * Created by simon on 2020/2/21.
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        Stack<ListNode> listNodes = new Stack<>();

        ListNode oneNode = head;
        for (int i = 0; i < k; i++) {
            if(oneNode == null){
                break;
            }
            listNodes.push(oneNode);
            oneNode = oneNode.next;
        }

        if(listNodes.size() == k){
            ListNode newHead = listNodes.pop();
            ListNode restNodes = reverseKGroup(newHead.next, k);
            ListNode node = newHead;
            for (int i = 0; i < k-1; i++) {
                ListNode listNode = listNodes.pop();
                node.next = listNode;
                node = listNode;
                if(i == k - 1 - 1){
                    node.next = restNodes;
                }
            }
            return newHead;
        }else{
            return head;
        }
    }



}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}