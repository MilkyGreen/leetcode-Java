package p300plus.p897;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {

        if(root == null){
            return null;
        }

        TreeNode left = root;
        TreeNode right = null;

        if(root.left != null){
            left = increasingBST(root.left);
            rightMost(root.left).right = root;
            root.left = null;
        }

        if(root.right != null){
            right = increasingBST(root.right);

            root.right = right;
        }
        
        return left;

    }

    private TreeNode rightMost(TreeNode node){
        TreeNode n = node;
        while(n.right != null){
            n = n.right;
        }
        return n;
    }
}
