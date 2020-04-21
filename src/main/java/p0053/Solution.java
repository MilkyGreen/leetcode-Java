package p0053;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/4/14 10:40
 */
public class Solution {

    // 尝试用dp解决(case数据太多的情况下内存不够了...)
    public int maxSubArray1(int[] nums) {
        int l = nums.length;
        // 两个下标之间的和
        int[][] dp = new int[l][l];
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            ans = Math.max(dp[i][i],ans);
            for (int j = i-1; j >= 0 ; j--) {
                dp[j][i] = dp[i][i] + dp[j][i-1];
                ans = Math.max(dp[j][i],ans);
            }
        }
        return ans;
    }

    // 正确答案
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        int ans = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < l; i++) {
            // 关键是对负值的处理，如果nums[i]是负，currMax 就大于 currMax + nums[i]，
            // 最终currMax=nums[i]，相当于开始新的窗口，直到遇到正值，再开始累加
            currMax = Math.max(currMax + nums[i],nums[i]);
            // ans获取每个阶段最大值，就是全局最大值。（也是一种动态规划思想，嗯，动规不一定非得用dp数组...）
            ans = Math.max(ans,currMax);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {-57,9,-72,-72,-62,45,-97,24,-39,35,-82,-4,-63,1,-93,42,44,1,-75,-25,-87,-16,9,-59,20,5,-95,-41,4,-30,47,46,78,52,74,93,-3,53,17,34,-34,34,-69,-21,-87,-86,-79,56,-9,-55,-69,3,5,16,21,-75,-79,2,-39,25,72,84,-52,27,36,98,20,-90,52,-85,44,94,25,51,-27,37,41,-6,-30,-68,15,-23,11,-79,93,-68,-78,90,11,-41,-8,-17,-56,17,86,56,15,7,66,-56,-2,-13,-62,-77,-62,-12,37,55,81,-93,86,-27,-39,-3,-30,-46,6,-8,-79,-83,50,-10,-24,70,-93,-38,27,-2,45,-7,42,-57,79,56,-57,93,-56,79,48,-98,62,11,-48,-77,84,21,-47,-10,-87,-49,-17,40,40,35,10,23,97,-63,-79,19,6,39,62,-38,-27,81,-68,-7,60,79,-28,-1,-33,23,22,-48,-79,51,18,-66,-98,-98,50,41,13,-63,-59,10,-49,-38,-70,56,77,68,95,-73,26,-73,20,-14,83,91,61,-50,-9,-40,1,11,-88,-80,21,89,97,-29,8,10,-15,48,97,35,86,-96,-9,64,48,-37,90,-26,-10,-13,36,-27,-45,-3,-1,45,34,77,-66,22,73,54,11,70,-97,-81,-43,-13,44,-69,-78,30,-66,-11,-29,58,52,-61,-68,-81,25,44,-32,57,-81,66,2,52,43,35,-26,16,-33,61,-37,-54,80,-3,32,24,27,30,-69,38,-81,2,-4,47,17,5,42,-58,-51,-90,98};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }

}