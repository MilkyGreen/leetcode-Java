package p300plus.p652;

public class Solution {
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> ret = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ret;
    }

    String dfs(TreeNode node){
        if(node == null){
            return "";
        }
        String str = "(" + dfs(node.left) + ")" + node.val + "(" + dfs(node.right) + ")";
        int cnt = map.getOrDefault(str,0);
        cnt++;
        if(cnt == 2){
            ret.add(node);
        }
        map.put(str,cnt);
        return str;
    }
}
