package p200.p144;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 二叉树的前序遍历（根节点->左节点->右节点）
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traceBack(root,res);
        return res;
    }

    private void traceBack(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        traceBack(root.left,res);
        traceBack(root.right,res);
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
