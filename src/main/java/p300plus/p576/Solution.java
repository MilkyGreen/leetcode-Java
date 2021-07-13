package p300plus.p576;

/**
 */
public class Solution {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int)Math.pow(10,9)+7;
        // dp[i][j][n] 代表位置i,j 在还剩n步时有多少路径
        int[][][] dp = new int[m][n][maxMove+1];

        // 初始化边缘,不论剩多少步，都至少有一条出口
        for (int i = 0; i < m; i++) {
            for (int step = 1; step <= maxMove; step++) {
                dp[i][0][step] += 1;
                dp[i][n-1][step] += 1;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int step = 1; step <= maxMove; step++) {
                dp[0][j][step] += 1;
                dp[m-1][j][step] += 1;
            }
        }

        for (int i = 1; i <= maxMove; i++) {
            // 注意j和k仍然要以0开始，因为之前初始化只设置了至少有一条路径，还可以从其他三个方向获取路径
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    // 向四个方向获取路径数，注意不要越界
                    if(j+1 < m){
                        dp[j][k][i] += dp[j+1][k][i-1];
                        dp[j][k][i] %= mod;
                    }
                    if(k +1 < n){
                        dp[j][k][i] += dp[j][k+1][i-1];
                        dp[j][k][i] %= mod;
                    }
                    if(j - 1 >= 0){
                        dp[j][k][i] += dp[j-1][k][i-1];
                        dp[j][k][i] %= mod;
                    }
                    if(k-1>=0){
                        dp[j][k][i] += dp[j][k-1][i-1];
                        dp[j][k][i] %= mod;
                    }

                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}
