package p300.p300;

import java.util.Arrays;

/**
 * <p>
 */
public class Solution {

    // 最长严格上升子序列
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l]; // dp[i] 代表以i结尾最大上升序列长度
        Arrays.fill(dp, 1);
        int ans = dp[0];
        for (int i = 1; i < l; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(new Solution().lengthOfLIS(nums));
    }

}
