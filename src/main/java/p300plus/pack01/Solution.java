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
    public int maxValue2(int n, int c, int[] v, int[] w) {
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

    public int maxValue(int N, int C, int[] w, int[] v) {
        int[][] dp = new int[N][C+1];
        // 先处理「考虑第一件物品」的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = i >= v[0] ? w[0] : 0;
        }
        // 再处理「考虑其余物品」的情况
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C + 1; j++) {
                // 不选该物品
                int n = dp[i-1][j];
                // 选择该物品，前提「剩余容量」大于等于「物品体积」
                int y = j >= v[i] ? dp[i-1][j-v[i]] + w[i] : 0;
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[N-1][C];
    }


    public int maxValue3(int N, int C, int[] w, int[] v) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < N; i++) {
            for (int j = C; j >= v[i]; j--) {
//            for (int j = 0; j <= C; j++) {
                if(j >= v[i]){
                    // 不选该物品
                    int n = dp[j];
                    // 选择该物品
                    int y = dp[j-v[i]] + w[i];
                    dp[j] = Math.max(n, y);
                }
            }
        }
        return dp[C];
    }
    // 输入: N = 3, V = 4, v = [4,2,3], w = [4,2,3]
    public static void main(String[] args){
        int n = 3;
        int c = 6;
        int[] v = new int[]{4,2,3};
        int[] w = new int[]{4,3,3};
        System.out.println(new Solution().maxValue2(n,c,v,w));
    }
}
