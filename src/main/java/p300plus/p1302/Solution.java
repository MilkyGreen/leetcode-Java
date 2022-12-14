package p300plus.p1302;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> dqueue = new LinkedList<>();

        int ret = 0;
        dqueue.offer(root);
        while(dqueue.size() > 0){
            int n = dqueue.size();
            int sum = 0;
            for(int i = 0;i < n;i++){
                TreeNode node = dqueue.poll();
                sum += node.val;
                if(node.left != null){
                    dqueue.offer(node.left);
                }
                if(node.right != null){
                    dqueue.offer(node.right);
                }
            }
            ret = sum;
        }
        return ret;
    }
}
