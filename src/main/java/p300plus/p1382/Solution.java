package p300plus.p1382;

public class Solution {
    // 中序遍历列表
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildNode(0,list.size()-1);
    }

    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    // 每次取中间的元素作为节点，左右节点再取中间
    TreeNode buildNode(int left ,int right){
        int mid = left + ((right - left) >> 1);
        TreeNode n = new TreeNode(list.get(mid));
        if(mid - 1 >= left){
            n.left = buildNode(left,mid - 1);
        }
        if(mid + 1 <= right){
            n.right = buildNode(mid + 1,right);
        }
        return n;
    }
}
