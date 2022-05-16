package p200.p145;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 记录上一次变量的节点
        TreeNode prev = null;
        while(root != null || stack.size() > 0){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            // 节点没有右节点，或者上一次遍历的就是右节点，说明该root遍历了
            if(root.right == null || root.right == prev){
                ret.add(root.val);
                prev = root;
                root = null;
            }else{
                // 右节点还没遍历，先把root再入栈
                stack.push(root);
                // 下一轮处理右节点
                root = root.right;
            }
        }
        return ret;
    }
}
