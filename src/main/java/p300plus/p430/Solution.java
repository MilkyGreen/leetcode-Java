package p300plus.p430;

public class Solution {
    public Node flatten(Node head) {
        
        Node curr = head;
        Node pre = null;

        while(curr != null){
            if(pre != null){
                pre.next = curr;
            }
            curr.prev = pre;
            
            Node next = curr.next;
            if(curr.child != null){
                Node childStart = curr.child;
                Node endNode = returnEnd(flatten(childStart));

                curr.next = childStart;
                childStart.prev = curr;

                pre = endNode;
                curr.child = null;
            }else{
                pre = curr;
            }
            curr = next;
        }

        return head;
    }

    public Node returnEnd(Node head) {
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        return node;
    }
}
