package p100.p0098;

/**
 *给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class Solution {

    /**
     * 看来的思路：关键是要确保root左边的所有节点都要比root小，右边一样。因此不能只跟自己的父节点比，还要跟父节点的父节点比
     * 比如：左子树a要小于父节点，但是如果父节点是一个右节点的话，a还是大于父节点的父节点。
     * 由此引入min和max两个比较变量，节点是左子树的时候，max是父节点，min来自父节点的min。反之亦然。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    private boolean validate(TreeNode node,long min,long max){
        if(node == null){
            return true;
        }
        if(node.val >= max || node.val <= min){
            return false;
        }

        return validate(node.left,min,node.val) && validate(node.right,node.val,max);
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