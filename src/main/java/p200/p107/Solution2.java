package p200.p107;

public class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        LinkedList<TreeNode> dqueue = new LinkedList<>();
        dqueue.addLast(root);
        while(dqueue.size() > 0){
            List<Integer> list = new ArrayList<>();
            int n = dqueue.size();
            for(int i = 0;i < n;i++){
                TreeNode node = dqueue.removeFirst();
                list.add(node.val);
                if(node.left != null){
                    dqueue.addLast(node.left);
                }
                if(node.right != null){
                    dqueue.addLast(node.right);
                }
            }
            ret.add(list);
        }
        int len = ret.size();
        int left = 0;
        int right = len - 1;
        while(left < right){
            List<Integer> temp = ret.get(left);
            ret.set(left,ret.get(right));
            ret.set(right,temp);
            left++;
            right--;
        }
        return ret;
    }
}
