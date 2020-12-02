package p200.p106;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * //根据一棵树的中序遍历与后序遍历构造二叉树。
 * //
 * // 注意:
 * //你可以假设树中没有重复的元素。
 * //
 * // 例如，给出
 * //
 * // 中序遍历 inorder = [9,3,15,20,7]
 * //后序遍历 postorder = [9,15,7,20,3]
 * //
 * // 返回如下的二叉树：
 * //
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * //
 */
public class Solution {
    /**
     * 中序：（「左子树」「根节点」「右子树」）、后序：（「左子树」「右子树」「根节点」）
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            index.put(inorder[i],i);
        }
        return buildTree(inorder,postorder,0,n-1,0,n-1);
    }

    Map<Integer,Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder,int inStart,int inEnd,int postStart,int postEnd){

        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        int postRoot = postEnd; // 后序的根节点在最后
        // 找到根节点在中序数组中的位置
        Integer inRoot = index.get(postorder[postRoot]);

        // 计算出中序数组中左子树的数量（与后序中是相等的）
        int leftTreeNum = inRoot - inStart;
        // 构造根节点
        TreeNode root = new TreeNode(postorder[postRoot]);

        root.left = buildTree(inorder,postorder,inStart,inRoot-1,postStart,postStart+leftTreeNum-1);
        root.right = buildTree(inorder,postorder,inRoot+1,inEnd,postStart+leftTreeNum,postRoot-1);
        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}