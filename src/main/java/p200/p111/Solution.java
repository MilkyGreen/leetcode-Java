package p200.p111;

/**
 * //给定一个二叉树，找出其最小深度。
 * //
 * // 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * //
 * // 说明：叶子节点是指没有子节点的节点。
 * //
 * //
 */
public class Solution {
    int min = 0;
    public int minDepth(TreeNode root) {
        dfs(root,1);
        return min;
    }
    private void dfs(TreeNode root,int height){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(min == 0){
                min = height;
            }else {
                min = Math.min(height,min);
            }
            return;
        }
        dfs(root.left,height+1);
        dfs(root.right,height+1);
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