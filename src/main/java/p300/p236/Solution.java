package p300.p236;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 */
public class Solution {

    TreeNode p;
    TreeNode q;
    boolean pFound = false;
    boolean qFound = false;
    // 遍历分别找到两个节点，按照 中 左 右的顺序记录他们的路径。把路径长的一方先截断到和短的一样，然后循环比较路径值是否一致
    // 一次ac，yes！
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        Deque<TreeNode> pPath = new ArrayDeque<>();
        Deque<TreeNode> qPath = new ArrayDeque<>();
        dfs(root,pPath,qPath);
        Deque<TreeNode> longer = pPath.size() > qPath.size() ? pPath:qPath;
        Deque<TreeNode> shorter = pPath.size() > qPath.size() ? qPath:pPath;
        int i = longer.size() - shorter.size();
        // 从后删除长的路径，直到跟短的一样。
        while (i > 0){
            longer.removeLast();
            i--;
        }
        // 分别从后遍历两个路径
        while (longer.size() > 0){
            TreeNode treeNode = longer.removeLast();
            TreeNode treeNode1 = shorter.removeLast();
            if(treeNode.val == treeNode1.val){
                return treeNode;
            }
        }
        return root;
    }

    // 遍历找到两个节点，记录下他们的路径
    private void dfs(TreeNode node, Deque<TreeNode> pPath,Deque<TreeNode> qPath){
        if (node == null){
            return;
        }
        if(pFound && qFound){
            return;
        }
        if(!pFound){
            pPath.addLast(node);
            if(node.val == p.val){
                pFound = true;
            }
        }
        if(!qFound){
            qPath.addLast(node);
            if(node.val == q.val){
                qFound = true;
            }
        }
        dfs(node.left,pPath,qPath);
        dfs(node.right,pPath,qPath);
        if(!pFound){
            pPath.removeLast();
        }
        if(!qFound){
            qPath.removeLast();
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
