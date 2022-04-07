package p200.p114;

public class Solution2 {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        doFlatten(root);
    }
    
    TreeNode doFlatten(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
    
        TreeNode leftEnd = doFlatten(left);
        TreeNode rightEnd = doFlatten(right);
    
        if(left != null){
            root.right = left;
        }else{
            leftEnd = root;
        }
        leftEnd.right = right;
        return rightEnd == null ? leftEnd : rightEnd;
    }



    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode next = curr.left;
                // 前驱节点，就是左子树的最后节点。其后面要跟右子树。因此先找到前驱，将右子树接到后面。
                TreeNode predeaccess = next;
                while(predeaccess.right != null){
                    predeaccess = predeaccess.right;
                }
                predeaccess.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            // 此时curr只有右边
            curr = curr.right;
        }
    }
}
