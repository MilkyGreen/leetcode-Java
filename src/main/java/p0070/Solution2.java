package p0070;

/**
 * <p>
 * Copyright: Copyright (c) 2020/6/2 23:22
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution2 {

    /**
     * 动态规划法解题
     * n层的路径数等于 n-1 + n-2 层路径只和，依次向下求解，而已知第1层1条路径，第2层2条。
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().climbStairs(44));
    }
}
