package p0072;

/**
 * <p>
 * Copyright: Copyright (c) 2020/6/9 22:34
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution2 {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < n+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                int left = dp[i - 1][j] + 1;
                int right = dp[i][j-1] + 1;
                int left_down = dp[i-1][j-1] + 1;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    left_down--;
                }
                dp[i][j] = Math.min(left,Math.min(right,left_down));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        System.out.println(new Solution2().minDistance("intention","execution"));
    }

}
