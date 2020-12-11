package p200.p114;

/**
 * <p>
 *     //给定一个二叉树，原地将它展开为一个单链表。
 * //
 * //
 * //
 * // 例如，给定二叉树
 * //
 * //     1
 * //   / \
 * //  2   5
 * // / \   \
 * //3   4   6
 * //
 * // 将其展开为：
 * //
 * // 1
 * // \
 * //  2
 * //   \
 * //    3
 * //     \
 * //      4
 * //       \
 * //        5
 * //         \
 * //          6
 */
public class Solution {

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    /**
     * 寻找前驱节点，然后把right放到前驱节点上
     * @param root
     */
    public void flatten2(TreeNode root){
        TreeNode curr = root;
        while (curr != null){
            if(curr.left != null){

                TreeNode next = curr.left;// 下个左节点
                TreeNode predeaccess = next; // 前驱节点
                while (predeaccess.right != null){
                    predeaccess = predeaccess.right;
                }
                predeaccess.right = curr.right;
                curr.right = next;
                curr.left = null;
            }
            curr = curr.right;// 此刻curr的left已经为空了。
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


