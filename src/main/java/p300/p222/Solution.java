public class Solution {
    int depth = 0;
    int bottomNodes = 0;
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        TreeNode node = root;
        while(node != null){
            depth++;
            node = node.left;
        }

        dfs(root,1);
        int lastLevelNodes = 1;
        int ret = lastLevelNodes;
        for(int i = 2;i <= depth;i++){
            lastLevelNodes *= 2;
            ret += lastLevelNodes;
        }
        if(lastLevelNodes != bottomNodes){
            ret -= lastLevelNodes;
            ret += bottomNodes;
        }
        return ret;
    }

    private boolean dfs(TreeNode node,int level){
        if(node == null){
            return true;
        }
        
        if(level == depth){
            bottomNodes++;
        }
        if(!dfs(node.left,level+1)){
            return false;
        }
        if(level == depth-1 && (node.left == null || node.right == null)){
            return false;
        }
        return dfs(node.right,level+1);

    }
}
