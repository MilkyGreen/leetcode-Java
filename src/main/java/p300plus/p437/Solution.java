package p300plus.p437;

public class Solution {
    int ret = 0;
    Map<Long,Integer> map = new HashMap<>();
    int t;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        this.t = targetSum;
        map.put(0L,1);
        dfs(root,root.val);
        return ret;
    }

    void dfs(TreeNode root,long sum){
        if(map.containsKey(sum - t)){
            ret += map.get(sum - t);
        }
        map.put(sum, map.getOrDefault(sum,0)+1);
        if(root.left != null){
            dfs(root.left, sum+root.left.val);
        }
        if(root.right != null){
            dfs(root.right, sum+root.right.val);
        }
        map.put(sum, map.get(sum)-1);
    }
}
