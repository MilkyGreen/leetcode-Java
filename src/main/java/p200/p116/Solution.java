package p200.p116;

/**
 * <p>
 */
public class Solution {

    public Node connect(Node root) {

        if(root == null){
            return null;
        }

        Node mostLeftNode = root;

        while (mostLeftNode.left != null){
            Node node = mostLeftNode;
            while (node != null){
                node.left.next = node.right;
                if(node.next != null){
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            mostLeftNode = mostLeftNode.left;
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