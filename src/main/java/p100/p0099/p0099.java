package p100.p0099;

/**
 * <p>
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 */
public class p0099 {

    // 思路：中序遍历搜索二叉树，是按升序排列的。如果遍历过程中发现pre大于next，说明找到了错排的元素。记住两个错误元素，遍历完之后交换即可。

    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if(x!=null && y!=null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(pre != null){
            if(pre.val > node.val){ // 发现不符合规则元素
                y = node; // 当前节点不断更新，因为如果pre是错放的，node就是正确的。只有后面的小node才是被交换过去的。
                if(x == null){
                    x = pre; // 第一次发现pre大的，说明pre就是从后面交换过来的，后面就不更新了。
                }
            }
        }
        pre = node;
        dfs(node.right);
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
