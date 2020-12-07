package p200.p109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * //给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * //
 * // 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * //
 * // 示例:
 * //
 * // 给定的有序链表： [-10, -3, 0, 5, 9],
 * //
 * //一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * //
 * //      0
 * //     / \
 * //   -3   9
 * //   /   /
 * // -10  5
 * //
 */
public class Solution {


    /**
     * 先转为数组，再按数组转平衡二叉树的方法做。通过了，不过速度很慢。
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = listNodeToArray(head);
        return toTree(list,0,list.size()-1);
    }

    private TreeNode toTree(List<Integer> list,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Integer root = list.get(mid);
        TreeNode treeNode = new TreeNode(root);
        treeNode.left = toTree(list,start,mid - 1);
        treeNode.right = toTree(list,mid+1,end);
        return treeNode;
    }

    private List<Integer> listNodeToArray(ListNode head){
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}