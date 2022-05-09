public class Solution3 {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return s == null && p == null;
        }else{
            int sl = s.length();
            int pl = p.length();
            // if(sl == 0 || pl == 0){
            //     return sl == 0 && pl == 0;
            // }
            boolean[][] dp = new boolean[sl+1][pl+1];
            dp[0][0] = true;
            // *可以匹配空
            for(int i = 1;i <= pl;i++){
                if(p.charAt(i-1) == '*'){
                    dp[0][i] = true;
                }else{
                    break;
                }
            }
            for(int i = 1;i <= sl;i++){
                for(int j = 1;j <= pl;j++){
                    char pc = p.charAt(j-1);
                    char sc = s.charAt(i-1);
                    if(pc == '*'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }else if(pc == '?' || pc == sc){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
            return dp[sl][pl];
        }
    }
}
