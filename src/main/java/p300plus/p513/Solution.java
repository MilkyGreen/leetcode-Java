package p300plus.p513;

public class Solution {
    int maxDepth = 0;
    int ret = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return ret;
    }

    void dfs(TreeNode node,int depth){
        if(node != null){
            depth++;
            if(depth > maxDepth){
                maxDepth = depth;
                ret = node.val;
            }
            dfs(node.left,depth);
            dfs(node.right,depth);
        }
    }
}
