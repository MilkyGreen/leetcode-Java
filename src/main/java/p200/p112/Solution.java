package p200.p112;

/**
 * <p>
 *     //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * //
 * // 说明: 叶子节点是指没有子节点的节点。
 * //
 * // 示例:
 * //给定如下二叉树，以及目标和 sum = 22，
 * //
 * //               5
 * //             / \
 * //            4   8
 * //           /   / \
 * //          11  13  4
 * //         /  \      \
 * //        7    2      1
 * //
 * //
 * // 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Solution {

    boolean res = false; // 结果，是否存在正确路径

    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root,0,sum);
        return res;
    }

    private void dfs(TreeNode node, int current, int sum) {
        if (node == null) {
            return;
        }
        if(res){ // 存在正确路径，下面的不用再看了
           return;
        }
        current += node.val;
        if(node.left == null && node.right == null){  // 如果是叶子节点
            if (sum == current) { // 找到答案了
                res = true;
                return;
            }else if(current > sum){ // 如果当前和已经大于sum，就不必往下找了
                return;
            }
        }
        dfs(node.left, current, sum);
        dfs(node.right, current, sum);
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