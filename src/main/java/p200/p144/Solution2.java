package p200.p144;

public class Solution2 {
    // 中 左 右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || stack.size() > 0){
            while(root != null){
                // 每次入栈之前获取值
                ret.add(root.val);
                stack.push(root);
                // 然后一直向左边遍历
                root = root.left;
            }
            root = stack.pop();
            // 左边已经遍历完了，处理右边
            root = root.right;
        }
        return ret;
    }
}
