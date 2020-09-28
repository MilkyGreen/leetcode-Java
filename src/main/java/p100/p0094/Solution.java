package p100.p0094;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class Solution {

    /**
     * 思路：中序遍历是先遍历左边，再中间，再右边。简单的dfs遍历就可以
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traceBack(root,res);
        return res;
    }

    private void traceBack(TreeNode node,List<Integer> res){
        if(node == null){
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        traceBack(left,res);
        res.add(node.val); // 只记录当前节点数据。因为不管左边还是右边，真正处理的时候，都是当前节点
        traceBack(right,res);
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