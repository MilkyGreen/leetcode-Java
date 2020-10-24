package p100.p0100;

/**
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Solution {

    /**
     * 思路：同时中序遍历两个树，比较每个节点值是否一致，遇到不相等的返回false即可。击败 100% Java提交。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null  ||  q == null){
            return p == q;
        }

        if(!isSameTree(p.left,q.left)){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        if(!isSameTree(p.right,q.right)){
            return false;
        }

        return true;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}