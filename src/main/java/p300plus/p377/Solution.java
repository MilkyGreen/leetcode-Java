package p300plus.p377;

public class Solution {
    int ret = 0;
    int[] nums;
    int target;

    // 方法1，记忆化搜索
    Map<Integer,Integer> memo = new HashMap<>();
    public int combinationSum42(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return dfs(target);
    }

    private int dfs(int sum){
        if(sum == 0){
            return 1;
        }
        if(sum < 0){
            return 0;
        }
        int ret = 0;
        for(int n : nums){
            if(sum - n >= 0){
                if(memo.containsKey(sum-n)){
                    ret += memo.get(sum-n);
                }else{
                    int res = dfs(sum-n);
                    memo.put(sum-n,res);
                    ret += res;
                }
            }
        }
        return ret;
    }

    // 动态规划
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1;i <= target;i++){
            for(int n : nums){
                if(i >= n){
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
