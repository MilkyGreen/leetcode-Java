package p100.p0010;

public class Solution3 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int i = 0;i <= m;i++){
            for(int j = 1;j <= n;j++){
                // p当前不是*，看i和j的字符是否相当
                if(p.charAt(j - 1) != '*'){
                    if(i > 0){
                        dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                    }
                }else{
                    // p当前是*，两种情况，p[j-2] == s[i-1]，则可以匹配s的一个字符，看dp[i-1][j]。或者不管是否相等，舍弃*和前面的一个字符，看dp[i][j-2]
                    if(i > 0 && j >= 2 && (s.charAt(i-1) == p.charAt(j-2)|| p.charAt(j-2) == '.')){
                        dp[i][j] = dp[i-1][j];
                    }
                    if(j >= 2){
                        dp[i][j] = dp[i][j] || dp[i][j-2];
                    }
                    
                }
            }
        }
        return dp[m][n];
    }
}
