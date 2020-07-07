package p100.p0044;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/31 9:59
 */
public class Solution2 {

    public boolean isMatch(String s, String p) {

        if(p.length() == 0){
            return s.length() == 0;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if('*' == p.charAt(i-1) && dp[0][i-1]){
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || '?' == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else if('*' == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isMatch("mississippi", "m??*ss*?i*pi"));
    }
}
