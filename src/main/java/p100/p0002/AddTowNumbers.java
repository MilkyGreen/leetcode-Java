package p100.p0002;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/20 16:50
 */
public class AddTowNumbers {

    public ListNode addTowNumbers(ListNode l1,ListNode l2){
        boolean carry = false;
        int carryLimit = 10;

        int first = l1.val + l2.val;
        if(first >= carryLimit){
            carry = true;
            first = first - carryLimit;
        }
        ListNode ans = new ListNode(first);
        ListNode oldNode;
        ListNode newNode = ans;

        l1 = l1.next;
        l2 = l2.next;

        while (true) {

            if (l1 == null && l2 == null) {
                if(carry){
                    newNode.next = new ListNode(1);
                }
                return ans;
            }

            int l1value = 0;
            int l2value = 0;
            oldNode = newNode;
            if (l1 != null) {
                l1value = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2value = l2.val;
                l2 = l2.next;
            }

            int sumVal = l1value + l2value;
            if (carry) {
                sumVal++;
                carry = false;
            }
            if (sumVal >= carryLimit) {
                carry = true;
                sumVal = sumVal - carryLimit;
            }
            newNode = new ListNode(sumVal);
            oldNode.next = newNode;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
