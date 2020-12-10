package p200.p113;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * //给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * //
 * // 说明: 叶子节点是指没有子节点的节点。
 * //
 * // 示例:
 * //给定如下二叉树，以及目标和 sum = 22，
 * //
 * //               5
 * //             / \
 * //            4   8
 * //           /   / \
 * //          11  13  4
 * //         /  \    / \
 * //        7    2  5   1
 * //
 * //
 * // 返回:
 * //
 * // [
 * //   [5,4,11,2],
 * //   [5,8,4,5]
 * //]
 * //
 */
public class Solution {
    /**
     * 思路：dfs，用双端队列保存路径上的所有元素，符合条件的路径放入结果集中。
     */
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root != null){
            dfs(new ArrayDeque<Integer>(),0,sum,root);
        }
        return res;
    }

    private void dfs(Deque<Integer> path,int currSum,int sum,TreeNode node){
        int val = node.val;
        path.addLast(val);
        currSum += val;

        if(node.left == null && node.right == null){ // 叶子节点
            if(currSum == sum){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if(node.left != null){
            dfs(path,currSum,sum,node.left);
            path.removeLast();  // 去掉上面放进队列的元素
        }
        if(node.right != null){
            dfs(path,currSum,sum,node.right);
            path.removeLast();
        }
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