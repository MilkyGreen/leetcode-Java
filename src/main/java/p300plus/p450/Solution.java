package p300plus.p450;

public class Solution {
    /**
     * 1、如果目标节点是叶子节点，直接删除
     * 2、只有左或者右节点，有子节点替代
     * 3、左右节点都有，寻找后继节点，即右子树里最小的节点，替代目标节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.left == null){
                root = root.right;
            }else if(root.right == null){
                root = root.left;
            }else{
                root.val = getNextNode(root).val;
            }
        }
        return root;
    }

    // 寻找并删除后继节点
    TreeNode getNextNode(TreeNode root){
        TreeNode pre = root;
        TreeNode node = root.right;
        while(node.left != null){
            pre = node;
            node = node.left;
        }
        // 找到后继节点然后删除。后继节点只(可能)有又右子树，删除后把右子树接到pre上，如果pre就是root，则是root的right，否则是pre的left
        if(pre == root){
            root.right = node.right;
        }else{
            pre.left = node.right;
        }
        return node;
    }
}
