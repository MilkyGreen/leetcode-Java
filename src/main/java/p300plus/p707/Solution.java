package p300plus.p707;

public class Solution {
    class MyLinkedList {

        Node head;
        Node tail;
        int cap;
    
        public MyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            cap = 0;
        }
        
        public int get(int index) {
            if(index >= cap){
                return -1;
            }
            return getNodeAtIndex(index).val;
        }
        
        public void addAtHead(int val) {
            Node node = new Node();
            node.val = val;
            Node oldH = head.next;
    
            head.next = node;
    
            node.prev = head;
            node.next = oldH;
    
            oldH.prev = node;
            cap++;
        }
        
        public void addAtTail(int val) {
            Node node = new Node();
            node.val = val;
    
            Node oldT = tail.prev;
    
            tail.prev = node;
    
            node.next=tail;
            node.prev = oldT;
    
            oldT.next = node;
            cap++;
        }
        
        public void addAtIndex(int index, int val) {
    
            if(index > cap){
                return;
            }
    
            
            Node curr = getNodeAtIndex(index);
            Node node = new Node();
            node.val = val;
    
            Node prev = curr.prev;
    
            prev.next = node;
            curr.prev = node;
    
            node.prev = prev;
            node.next = curr;
            cap++;
        }
        
        public void deleteAtIndex(int index) {
            if(index >= cap){
                return;
            }
            Node curr = getNodeAtIndex(index);
            Node prev = curr.prev;
            Node next = curr.next;
    
            prev.next = next;
            next.prev = prev;
            cap--;
        }
    
        private Node getNodeAtIndex(int index){
            int i = 0;
            Node node = head.next;
            while(node != null){
                if(i == index){
                    return node;
                }
                node = node.next;
                i++;
            }
            return new Node();
        }
    
        class Node{
            int val;
            Node prev;
            Node next;
        }
    }
}
