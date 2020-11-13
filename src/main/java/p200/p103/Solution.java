package p200.p103;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class Solution {

    /**
     * 思路：广度优先遍历，根据层次的奇偶来判断一下元素放入list的位置是头还是尾。是的，list.add方法能插入任何位置
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        if(root == null){
            return res;
        }

        deque.addFirst(root);
        while (!deque.isEmpty()){
            // 当前层
            List<Integer> currLevel = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode last = deque.pollLast();
                if(res.size() % 2 == 0){
                    // 偶数层
                    currLevel.add(last.val);
                }else {
                    // 奇数层
                    currLevel.add(0,last.val);
                }
                if(last.left != null){
                    deque.addFirst(last.left);
                }
                if(last.right != null){
                    deque.addFirst(last.right);
                }
            }
            res.add(currLevel);
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