package p200.p146;

import java.util.Set;

/**
 * //运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * //
 * //
 * //
 * // 实现 LRUCache 类：
 * //
 * //
 * // LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * // int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * // void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
 * //限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * //
 * //
 * //
 * //
 * //
 * //
 * // 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * //
 * //
 * //
 * // 示例：
 * //
 * //
 * //输入
 * //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * //输出
 * //[null, null, null, 1, null, -1, null, -1, 3, 4]
 * //
 * //解释
 * //LRUCache lRUCache = new LRUCache(2);
 * //lRUCache.put(1, 1); // 缓存是 {1=1}
 * //lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * //lRUCache.get(1);    // 返回 1
 * //lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * //lRUCache.get(2);    // 返回 -1 (未找到)
 * //lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * //lRUCache.get(1);    // 返回 -1 (未找到)
 * //lRUCache.get(3);    // 返回 3
 * //lRUCache.get(4);    // 返回 4
 * //
 */
public class Solution {


}

/**
 * 思路：链表记录key和value,每次操作的节点移动到队尾。超过限制删除队首。  时间比较久，官方是用hashmap存的节点位置，省去了查找时间，比较无聊。。。
 */
class LRUCache {

    int capacity;
    //    Set<Integer> keys;
    Node head;
    Node tail;
    int currSize = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (currSize > 0) {
            Node target = null;
            Node node = head;
            while (node != null) { // 先寻找目标节点
                if (node.key == key) {
                    target = node;
                    break;
                } else {
                    node = node.next;
                }
            }
            if (target != null) { // 找到目标节点了，移动到队尾
                int value = target.value;
                Node pre = target.pre;
                Node next = target.next;
                if (pre != null && next != null) { // 如果在中间
                    pre.next = next;
                    next.pre = pre;
                } else if (pre == null && tail != target) { // 如果是头节点且不是尾节点
                    next.pre = null;
                    head = next;
                }
                if (tail != target) { // 放到队尾
                    target.next = null;
                    tail.next = target;
                    target.pre = tail;
                    tail = target;
                }
                return value;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (currSize > 0) {
            get(key); // 如果存在,会移动到最后
            if (tail.key == key) { // 更新已存在的值
                tail.value = value;
            } else { // 不存在，新增
                Node node = new Node();
                node.key = key;
                node.value = value;
                // 放在尾部
                tail.next = node;
                node.pre = tail;
                tail = node;

                currSize++;

                if (currSize > capacity) { // 如果超出容量，移除头节点
                    head = head.next;
                    head.pre = null;
                    currSize--;
                }
            }
        } else {
            Node node = new Node();
            node.key = key;
            node.value = value;
            this.head = node;
            this.tail = node;
            currSize++;
        }
    }

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));// 返回 4
    }
}
