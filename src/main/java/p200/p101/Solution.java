package p200.p101;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Solution {

    /**
     * 看来的思路：
     * 1.怎么判断一棵树是不是对称二叉树？ 答案：如果所给根节点，为空，那么是对称。如果不为空的话，当他的左子树与右子树对称时，他对称
     *
     * 2.那么怎么知道左子树与右子树对不对称呢？在这我直接叫为左树和右树 答案：如果左树的左孩子与右树的右孩子对称，左树的右孩子与右树的左孩子对称，那么这个左树和右树就对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isisSymmetric(root.left,root.right);
    }

    private boolean isisSymmetric(TreeNode left,TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return isisSymmetric(left.left,right.right) && isisSymmetric(left.right,right.left);
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
