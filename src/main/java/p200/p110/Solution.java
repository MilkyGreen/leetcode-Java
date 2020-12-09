package p200.p110;

/**
 * //给定一个二叉树，判断它是否是高度平衡的二叉树。
 * //
 * // 本题中，一棵高度平衡二叉树定义为：
 * //
 * //
 * // 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * //
 */
public class Solution {

    /**
     * 思路：从下往上递归计算高度，先计算左右的高度，取最大值加一就是根节点高度。如果左右高度差大于1，则根节点高度设为负一，
     * 左右任意节点为负一，根也为负一。最后得出的高度要么是正数（真正高度），要么是-1（不是平衡二叉树）
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
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

    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}