package p300plus.p530;

public class Solution {
    TreeNode pre = null;
    int ret = 100001;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(pre != null){
            ret = Math.min(ret,Math.abs(node.val - pre.val));
        }
        pre = node;
        dfs(node.right);
    }
}
