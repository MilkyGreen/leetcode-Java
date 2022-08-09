package p200.p106;

public class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd) {
        if(inStart > inEnd){
            return null;
        }
        if(inEnd == inStart){
            return new TreeNode(inorder[inStart]);
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int leftLen = 0;
        for(int i = inStart;i < inorder.length;i++){
            if(inorder[i] != postorder[postEnd]){
                leftLen++;
            }else{
                break;
            }
        }

        root.left = buildTree(inorder,inStart,inStart+leftLen-1,postorder,postStart,postStart+leftLen-1);

        root.right = buildTree(inorder, inStart+leftLen+1, inEnd, postorder, postStart+leftLen, postEnd-1);
        return root;
    }
}
