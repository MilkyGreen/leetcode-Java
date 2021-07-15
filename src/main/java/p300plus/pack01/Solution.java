package p300plus.pack01;

/**
 */
public class Solution {

    /**
     * 背包最大值
     * @param n 物品数量
     * @param c 背包容量
     * @param v 价值
     * @param w 重量
     * @return
     */
    public int maxValue(int n, int c, int[] v, int[] w) {
        // dp[i][j] 代表前i个物品，当容量是j时的最大价值
        int[] dp = new int[c+1]; // 转成一维度数组，表示当前个物品的最大值

        // 初始化第一个物品
        for (int i = 0; i <= c; i++) {
            dp[i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            // 主要这里一定要从c开始，因为dp[j] 依赖上一轮的dp[j]或者dp[j-w[i]] ，只能先更新大的，保证dp[j-w[i]]还是上一轮的。
            // 如果用二维数组，则从0可是也可以
            for (int j = c; j >= 0; j--) {
                int a = dp[j];
                if(j >= w[i]){
                    int b = dp[j-w[i]] + v[i];
                    dp[j] = Math.max(a,b);
                }else {
                    dp[j] = a;
                }
            }
        }
        return dp[c];
    }

    // 无限背包，每个值可以使用多次
    public int maxValueINF(int n, int c, int[] v, int[] w) {
        int[][] dp = new int[n][c+1];

        for (int i = 0; i < c; i++) {
            for(int j = 0 ;i >= j * w[0];j++){ // 第一个元素，尽可能选择多次
                dp[0][i] = j * v[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c; j++) {
                int a = dp[i-1][j];

                int b = 0;
                for(int k = 0;k*w[i]<=j;k++){ // 在能装下的情况下选择多次，取最大的那次
                    b = Math.max(b,dp[i-1][j-k*w[i] + k*v[i]]);
                }
                dp[i][j] = Math.max(a,b);
            }
        }
        return dp[n-1][c];
    }

    // 输入: N = 3, V = 4, v = [4,2,3], w = [4,2,3]
    public static void main(String[] args){
        int n = 3;
        int c = 6;
        int[] v = new int[]{4,2,3};
        int[] w = new int[]{4,3,3};
        System.out.println(new Solution().maxValue(n,c,v,w));
    }
}
