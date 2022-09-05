package p300plus.p1171;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer,ListNode> sums = new HashMap<>();

        ListNode node = dummy;
        int sum = 0;
        while(node != null){
            sum += node.val;
            sums.put(sum,node);
            node = node.next;
        }

        node = dummy;
        sum = 0;
        while(node != null){
            sum += node.val;
            
            node.next = sums.get(sum).next;

            node = node.next;
        }
        return dummy.next;
    }
}
