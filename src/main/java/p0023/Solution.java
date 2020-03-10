package p0023;

/**
 * Created by simon on 2020/2/19.
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return merge(lists,0,lists.length - 1);
    }

    private ListNode merge(ListNode[] lists,int left,int right){
        if(left == right){
            return lists[left];
        }
        int mid = left+(right -left)/2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists,mid+1,right);
        return merge2List(l1,l2);
    }

    private ListNode merge2List(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = merge2List(l1.next,l2);
            return l1;
        }else {
            l2.next = merge2List(l2.next,l1);
            return l2;
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