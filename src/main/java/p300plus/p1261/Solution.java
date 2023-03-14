package p300plus.p1261;

public class Solution {
    Set<Integer> set = new HashSet<>();
    TreeNode root;
    public FindElements(TreeNode root) {
        root = root;
        root.val = 0;
        recover(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    void recover(TreeNode root){
        set.add(root.val);
        if(root.left != null){
            root.left.val = root.val * 2 + 1;
            recover(root.left);
        }
        if(root.right != null){
            root.right.val = root.val * 2 + 2;
            recover(root.right);
        }
    }
}
