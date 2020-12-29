package p200.p117;

/**
 * <p>
 */
public class Solution {

    /**
     * 思路：由于上一层的next已经建立，下一层可以利用上层的next来找下一个需要连接的节点
     * 区别于116题，一个节点和其下一个节点的距离未知，用last记录上个节点，直到找到下一个节点，再连接。
     * 下一行的开始同理，需要保存第一个有子节点的节点。
     */

    Node last; // 记录上一次被连接的节点
    Node nextStart; // 记录下一行的开始节点
    public Node connect(Node root) {

        if(root == null){
            return null;
        }

        Node start = root;

        while (start != null){
            last = null; // 每遍历新的一行时要清空
            nextStart = null;
            Node node = start;
            while (node != null){
                if(node.left != null){
                    if(last != null){
                        last.next = node.left; // 连接到上一个节点上
                    }
                    last = node.left; // 自己变成上个节点
                    if(nextStart == null){ // 如果下一行开始还没有，赋一下值
                        nextStart = node.left;
                    }
                }

                if(node.right != null){
                    if(last != null){
                        last.next = node.right;
                    }
                    last = node.right;
                    if(nextStart == null){
                        nextStart = node.right;
                    }
                }
                node = node.next;
            }
            start = nextStart;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}