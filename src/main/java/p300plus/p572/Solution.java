package p300plus.p572;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null){
            return subRoot == null && root == null;
        }

        if(root.val == subRoot.val && eq(root, subRoot)){
            return true;
        }else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    boolean eq(TreeNode r,TreeNode s){
        if(r == null || s == null){
            return s == null && r == null;
        }
        if(r.val == s.val){
            return eq(r.left,s.left) && eq(r.right,s.right);
        }
        return false;
    }
}
