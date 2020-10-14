package p100.p0096;

/**
 * <p>
 *     给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Solution {

    public int numTrees(int n) {


        return 0;
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