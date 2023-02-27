package p300plus.p740;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxValue = nums[0];
        for(int n : nums){
            maxValue = Math.max(maxValue,n);
        }

        int[] alls = new int[maxValue+1];
        for(int n : nums){
            alls[n] += n;
        }

        return rob(alls);
    }

    public int rob(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);

        for(int i = 2;i < nums.length;i++){
            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
