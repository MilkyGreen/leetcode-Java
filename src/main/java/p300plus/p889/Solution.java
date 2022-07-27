package p300plus.p889;

public class Solution {
    // preNum -> idx
    Map<Integer,Integer> preMap = new HashMap<>();
    // postNum -> idx
    Map<Integer,Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i = 0;i < preorder.length;i++){
            preMap.put(preorder[i],i);
            postMap.put(postorder[i],i);
        }

        return getNode(preorder,postorder,0,preorder.length-1,0,preorder.length-1);
    }

    TreeNode getNode(int[] preorder, int[] postorder,int preStart,int preEnd,int postStart,int postEnd){
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart == preEnd){
            return root;
        }
        
        int preLeftStart = preStart+1;
        int postLeftEnd = postMap.get(preorder[preLeftStart]);

        int leftLen =  postLeftEnd - postStart + 1;
        
        root.left = getNode(preorder,postorder,preLeftStart,preLeftStart + leftLen - 1,postStart,postStart + leftLen - 1);

        root.right = getNode(preorder,postorder,preLeftStart + leftLen,preEnd,postStart + leftLen,postEnd - 1);
        
        return root;
    }
}
