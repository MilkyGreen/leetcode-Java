package p100.p0096;

/**
 * <p>
 *     给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Solution {

    Map<Integer,Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n == 0){
            map.put(0,1);
            return 1;
        }
        if(n == 1 || n == 2){
            map.put(1,1);
            map.put(2,2);
            return n;
        }
        int ret = 0;
        for(int i = 0;i < n;i++){
            int left = numTrees(i);
            int right = numTrees(n-i-1);
            int num = left * right;
            ret += num;
        }
        map.put(n, ret);
        return ret;
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