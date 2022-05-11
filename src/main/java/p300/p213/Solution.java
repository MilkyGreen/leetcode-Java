package p300.p213;

public class Solution {
    // 两次动态规划，一次假设第一个家被偷了，那么最后一家肯定不能偷。第二次假设第一家没有偷，那么最后一家可能被偷。取两次的最大值
    public int rob(int[] nums) {
        int ret = 0;
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = nums[0];
        for(int i = 2;i < n;i++){
            if(i == n-1){
                f[i] = f[i-1];
            }else{
                f[i] = Math.max(f[i-2] + nums[i],f[i-1]);
            }
        }
        ret = f[n-1];

        f = new int[n];
        f[0] = 0;
        f[1] = nums[1];
        for(int i = 2;i < n;i++){
            f[i] = Math.max(f[i-2] + nums[i],f[i-1]);
        }
        ret = Math.max(ret,f[n-1]);
        return ret;
    }
}
