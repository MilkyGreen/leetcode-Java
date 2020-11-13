package p200.p104;

/**
 * <p>给定一个二叉树，找出其最大深度。
 */
public class Solution {

    int res = 0;

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode node,int level){
        level++;
        res = Math.max(res,level);
        if(node.left != null){
            dfs(node.left,level);
        }
        if(node.right != null){
            dfs(node.right,level);
        }
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