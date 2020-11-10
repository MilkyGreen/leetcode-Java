package p200.p102;



import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution {

    /**
     * 思路：广度优先遍历 BFS 。
     * 用例队列先进先出的特点，每次遍历一层的时候，将下一层放入队列。
     * 遍历过程中队列长度是不断变化的，在开始一层的遍历前先统计一下当前队列的元素，即本层元素数量n，连续遍历n次，本层就结束了。
     * 直到队列为空，证明结束了。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null){
            return res;
        }

        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>(); // 当前层集合
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
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