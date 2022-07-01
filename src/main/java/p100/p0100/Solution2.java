package p100.p0100;

public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return q == null && p == null;
        }
        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }
}
