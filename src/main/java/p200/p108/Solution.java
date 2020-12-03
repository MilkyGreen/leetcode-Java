package p200.p108;

/**
 * <p>
 * //将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * //
 * // 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * //
 * // 示例:
 * //
 * // 给定有序数组: [-10,-3,0,5,9],
 * //
 * //一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * //
 * //      0
 * //     / \
 * //   -3   9
 * //   /   /
 * // -10  5
 * //
 */
public class Solution {
    /**
     * 思路：先选定中间元素作为根节点，左右分别当做独立的数递归处理得到左右子树，连接到根节点即可。直到退出条件是子树不可分割了，代表找到了叶子节点。
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        int length = nums.length;

        return arrayToTree(nums, 0, length - 1);
    }

    private TreeNode arrayToTree(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode rootNode = new TreeNode(nums[mid]);
        rootNode.left = arrayToTree(nums, start, mid - 1);
        rootNode.right = arrayToTree(nums, mid + 1, end);
        return rootNode;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {-10,-3,0,5,9};
        solution.sortedArrayToBST(nums);
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