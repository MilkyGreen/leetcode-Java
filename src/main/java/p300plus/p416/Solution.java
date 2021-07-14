package p300plus.p416;

/**
 * <p>
 */
public class Solution {

    // 等分数组，转化为01背包问题
    public boolean canPartition(int[] nums) {
        int l = nums.length;
        int sums = 0;
        for (int i = 0; i < l; i++) {
            sums += nums[i];
        }
        int target = sums / 2;

        if (target * 2 != sums){
            return false;
        }

        int[] dp = new int[target +1];

        // 第一个数
        for (int i = 1; i <= target; i++) {
            dp[i] = i >= nums[0] ? nums[0] : 0;
        }

        for (int i = 1; i < l; i++) {
            int num = nums[i];
            for (int j = target; j >= 0; j--) {
                int a = dp[j];
                int b = j >= num? dp[j-num]+num :a;
                dp[j] = Math.max(a,b);
            }
        }
        return dp[target] == target;
    }

    // 直接求解的方式
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            sum+=nums[i];
        }
        int target = sum/2;
        if(target*2 != sum){
            return false;
        }
        boolean[] dp = new boolean[target+1]; //dp[j] 代表当前是否恰好容量为j
        dp[0] = true; // 容量为0，内容为0一定是true

        for (int i = 1; i <= l; i++) {
            int n = nums[i-1];
            for (int j = target; j >= 0; j--) {
                boolean a = dp[j]; // 如果上个符合，不选择当前元素
                boolean b = j >= n? dp[j-n] : dp[j]; // 如果容量减去当前后，符合，则符合。
                dp[j] = a || b;
            }
        }
        return dp[target];
    }

}
