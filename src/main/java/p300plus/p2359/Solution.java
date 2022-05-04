package p300plus.p2359;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        dfs(root, 0, target, new LinkedList());
        return ret;
    }

    void dfs(TreeNode node, int sum, int target, LinkedList<Integer> path) {

        sum += node.val;
        path.addLast(node.val);

        if (node.left == null && node.right == null) {
            if (sum == target) {
                ret.add(new ArrayList(path));
            }
            path.removeLast();
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum, target, path);
        }

        if (node.right != null) {
            dfs(node.right, sum, target, path);
        }

        path.removeLast();
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