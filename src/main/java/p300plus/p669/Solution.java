package p300plus.p669;

public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null ){
            return null;
        }
        if(root.val <= high && root.val >= low){
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }else{
            TreeNode left = trimBST(root.left, low, high);
            TreeNode right = trimBST(root.right, low, high);
            if(left == null && right == null){
                return null;
            }else if(right == null){
                return left;
            }else{
                return right;
            }
        }
    }
}
