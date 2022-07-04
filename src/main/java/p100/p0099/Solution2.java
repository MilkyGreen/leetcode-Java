package p100.p0099;

public class Solution2 {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    void dfs(TreeNode node){
        if(node != null){
            dfs(node.left);
            if(pre != null){
                if(node.val < pre.val){
                    if(first == null){
                        first = pre;
                        second = node;
                    }else {
                        second = node;
                        return;
                    }
                }
            }
            pre = node;
            dfs(node.right);
        }
    }
}
