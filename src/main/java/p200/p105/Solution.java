package p200.p105;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     根据一棵树的前序遍历与中序遍历构造二叉树。
 * //
 * // 注意:
 * //你可以假设树中没有重复的元素。
 * //
 * // 例如，给出
 * //
 * // 前序遍历 preorder = [3,9,20,15,7]
 * //中序遍历 inorder = [9,3,15,20,7]
 * //
 * // 返回如下的二叉树：
 * //
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 */
public class Solution {

    Map<Integer,Integer> index = new HashMap<>();

    /**
     * 思路：
     * 事实：1、前序和中序遍历处理的数组长度一样；2、前序：「根」「左子树」「右子树」，中序：「左子树」「根」「右子树」
     * 3、左右子树分别是一个独立的数
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            index.put(inorder[i],i); // 遍历中序，建立 元素值->数组索引位置 的关联，方便查询
        }
        return buildTree(preorder,inorder,0,n-1,0,n-1);
    }

    /**
     *
     * @param preorder 前序数组
     * @param inorder 中序数组
     * @param preLeft 前序开始位置
     * @param preRight 前序结束位置
     * @param inLeft 中序开始位置
     * @param inRight 中序结束位置
     * @return
     */
    private TreeNode buildTree(int[] preorder,int[] inorder,int preLeft,int preRight,int inLeft,int inRight){

        // 遇到了边界情况，说明递归到了叶子节点，返回null
        if(preLeft > preRight){
            return null;
        }

        int preRoot = preLeft; // 前序第一个元素就是根节点
        Integer inRoot = index.get(preorder[preRoot]); // 找到根节点在中序数组中的位置

        // 建根节点
        TreeNode root = new TreeNode(preorder[preRoot]);
        // 利用中序数组，计算左子树元素个数，这样就能算出前序中左右子树的边界
        int leftSubTreeNum = inRoot - inLeft;

        // 分别将左子树和右子树拆分，当做独立二叉树递归计算，结果与上面的根节点连接
        root.left = buildTree(preorder,inorder,preLeft + 1,preLeft + leftSubTreeNum,inLeft,inRoot-1);
        root.right = buildTree(preorder,inorder,preLeft + leftSubTreeNum+1,preRight,inRoot+1,inRight);
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