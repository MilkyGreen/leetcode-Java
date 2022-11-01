package p300plus.p501;

public class Solution {
    int max = 0;
    int base = 0;
    int count = 0;
    List<Integer> ret = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[ret.size()];
        for(int i = 0;i < ret.size();i++){
            res[i] = ret.get(i);
        }
        return res;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(base == node.val){
            count++;
        }else{
            base = node.val;
            count = 1;
        }
        if(count >= max){
            if(count > max){
                max = count;
                ret.clear();
            }
            ret.add(node.val);
        }

        dfs(node.right);
    }
}
