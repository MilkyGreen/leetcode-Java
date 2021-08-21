package p200.p146;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Copyright: Copyright (c) 2021/8/20 22:12
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution2 {
}

class LRUCache2 {

    int c;
    int size;
    Node head;
    Node tail;
    Map<Integer,Node> map;
    public LRUCache2(int capacity) {
        c = capacity;
        size = 0;
        map = new HashMap<>(c);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToHead(node);
            return head.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(head == null){
            head = new Node(key,value);
            tail = head;
            map.put(key,head);
            size++;
            return;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }
        if(size == c){
            map.remove(tail.key);
            if(tail == head){
                head = new Node(key,value);
                tail = head;
                map.put(key,head);
                return;
            }else{
                tail = tail.pre;
                tail.next = null;
            }
            Node node = new Node(key,value);
            map.put(key,node);
            addToHead(node);
        }else{
            Node node = new Node(key,value);
            map.put(key,node);
            moveToHead(node);
            size++;
        }
    }

    public void addToHead(Node node){
        node.pre = null;
        head.pre = node;
        node.next = head;
        head = node;
    }

    public void moveToHead(Node node){
        if(node == head){
            return;
        }
        Node pre = node.pre;
        Node next = node.next;
        if(pre != null){
            pre.next = next;
        }
        if(next != null){
            next.pre = pre;
        }
        if(node == tail){
            tail = pre;
        }
        addToHead(node);
    }


    public static void main(String[] args) {
        LRUCache2 lRUCache = new LRUCache2(1);
        lRUCache.put(2, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(2));    // 返回 1
        lRUCache.put(3, 2); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));// 返回 4
    }

}

class Node{
    int key;
    int val;
    Node pre;
    Node next;

    public Node(int key,int value){
        this.key = key;
        this.val = value;
    }
}
