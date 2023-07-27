package p300plus.p783;

public class Solution {
    int min = 100000;
    Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(pre != null){
            min = Math.min(node.val - pre,min);
        }
        pre = node.val;
        
        dfs(node.right);
    }
}
