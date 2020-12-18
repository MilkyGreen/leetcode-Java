package p200.p115;

/**
 * <p>
 * //给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * //
 * // 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
 * //，而 "AEC" 不是）
 * //
 */
public class Solution {

    /**
     * 思路：动态规划
     * https://leetcode-cn.com/problems/distinct-subsequences/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-27/
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {

        int s_len = s.length();
        int t_len = t.length();
        // dp[m][n] 代表s(m,s_len-1)包含多少个t(n,t_len-1)
        int[][] dp = new int[s_len+1][t_len+1];

        // 当n=t_len 代表t为空字符串，那么便获得了一个解,此时m的值可以从0到s_len-1
        for (int i = 0; i <= s_len; i++) {
            dp[i][t_len] = 1;
        }

        for (int t_i = t_len-1; t_i >= 0; t_i--) {
            for (int s_i = s_len-1; s_i >= 0; s_i--) {
                if(s.charAt(s_i) == t.charAt(t_i)){
                    dp[s_i][t_i] = dp[s_i+1][t_i] + dp[s_i+1][t_i+1];
                }else {
                    dp[s_i][t_i] = dp[s_i+1][t_i];
                }
            }
        }
        return dp[0][0];
    }

}
