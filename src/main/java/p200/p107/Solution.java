package p200.p107;

import java.util.*;

/**
 * <p>
 *     //给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * //
 * // 例如：
 * //给定二叉树 [3,9,20,null,null,15,7],
 * //
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * //
 * //
 * // 返回其自底向上的层次遍历为：
 * //
 * // [
 * //  [15,7],
 * //  [9,20],
 * //  [3]
 * //]
 */
public class Solution {

    /**
     * 思路：bfs遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() > 0){
            List<Integer> oneLevel = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(oneLevel);
        }

        Collections.reverse(res);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
