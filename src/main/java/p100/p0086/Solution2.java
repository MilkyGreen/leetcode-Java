package p100.p0086;

public class Solution2 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        ListNode small = dummy;
        ListNode greaterDummy = new ListNode();
        ListNode greater = greaterDummy;

        ListNode node = head;
        while(node != null){
            if(node.val >= x){
                greater.next = node;
                greater = greater.next;
            }else{
                small.next = node;
                small = small.next;
            }
            node = node.next;
        }
        greater.next = null;
        small.next = greaterDummy.next;
        return dummy.next;
    }
}
