package p200.p145;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     二叉树后序遍历(左 -> 右 -> 中)
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        traceBack(root,res);
        return res;
    }

    private void traceBack(TreeNode node,List<Integer> res){
        if(node == null){
            return;
        }
        traceBack(node.left,res);
        traceBack(node.right,res);
        res.add(node.val);
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