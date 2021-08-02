package p300plus.p1995;

/**
 * <p>
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] inorder,int index,int start,int end){
        if(index < 0 || start<0 || end<0 || start> end|| index >= preorder.length || start >= inorder.length ||
                end >= inorder.length ){
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[index]);
        int inorderIndex = start;
        for(;inorderIndex<=end;inorderIndex++){
            if(inorder[inorderIndex] == preorder[index]){
                break;
            }
        }

        if(inorderIndex > start){
            rootNode.left = build(preorder,inorder,index+1,start,inorderIndex-1);
        }
        rootNode.right = build(preorder,inorder,index+inorderIndex-start+1,inorderIndex+1,end);
        return rootNode;
    }



    public static void main(String[] args) {
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        new Solution().buildTree(pre,in);
    }

}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }