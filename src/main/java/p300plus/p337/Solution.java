package p300plus.p337;

public class Solution {
    Map<TreeNode,Integer> rmax = new HashMap<>();
    Map<TreeNode,Integer> umax = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(true,root);
    }

    int dfs(boolean canRob,TreeNode node){
        if(node == null){
            return 0;
        }

        int robMax = 0;
        int unRobMax = 0;
        if(umax.containsKey(node)){
            unRobMax = umax.get(node);
        }else{
            unRobMax = dfs(true,node.left)+dfs(true,node.right);
            umax.put(node,unRobMax);
        }
        
        if(canRob){
            if(rmax.containsKey(node)){
                robMax = rmax.get(node);
            }else{
                robMax = dfs(false,node.left)+dfs(false,node.right) + node.val;
                rmax.put(node,robMax);
            }
            
        }
        return Math.max(robMax,unRobMax);
    }
}
