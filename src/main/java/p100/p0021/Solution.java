package p100.p0021;

/**
 * Created by simon on 2020/2/18.
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else {
            ListNode result = new ListNode(0);
            ListNode nextNode = null;

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                boolean boo = l1.val < l2.val;
                int nextVal = boo ? l1.val:l2.val;

                ListNode listNode = new ListNode(nextVal);
                if(i == 0){
                    nextNode = listNode;
                    result.next = nextNode;
                }else{
                    nextNode.next = listNode;
                    nextNode = listNode;
                }

                if(boo){
                    l1 = l1.next;
                    if(l1 == null){
                        nextNode.next = l2;
                        break;
                    }
                }else {
                    l2 = l2.next;
                    if(l2 == null){
                        nextNode.next = l1;
                        break;
                    }
                }

            }
            return result.next;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next=l11;
        l11.next=l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next=l21;
        l21.next=l22;
        solution.mergeTwoLists(l1,l2);

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}