package p200.p111;

public class Solution2 {
    int ret = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, 1);
        return ret;
    }

    void dfs(TreeNode node,int depth){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            ret = Math.min(ret,depth);
            return;
        }
        if(depth > ret){
            return;
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}
