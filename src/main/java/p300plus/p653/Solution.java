package p300plus.p653;

public class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root,k);
    }

    boolean dfs(TreeNode node,int k){
        if(node != null){
            if(set.contains(k - node.val)){
                return true;
            }
            set.add(node.val);
            return dfs(node.left,k) || dfs(node.right,k);
        }else{
            return false;
        }
    }
}
