package p100.p0095;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 */
public class Solution {

    /** 方案来自官方解题官方解答实现
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return genTrees(1,n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = genTrees(start, i - 1);
            List<TreeNode> rightTrees = genTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightTree;
                    root.left = leftTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }


    /**
     * 新增元素
     *
     * @param root
     * @param val
     */
    private void insertNode(TreeNode root, int val) {
        if (root.val > val) {
            TreeNode left = root.left;
            if (left == null) {
                root.left = new TreeNode(val);
            } else {
                insertNode(left, val);
            }
        } else {
            TreeNode right = root.right;
            if (right == null) {
                root.right = new TreeNode(val);
            } else {
                insertNode(right, val);
            }
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

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}