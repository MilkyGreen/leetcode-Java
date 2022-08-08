package p300plus.p404;

public class Solution {
    int ret = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode root){

        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                ret += root.left.val;
            }else{
                dfs(root.left);
            }
            
        }
        if(root.right != null){
            dfs(root.right);
        }
    }
}
