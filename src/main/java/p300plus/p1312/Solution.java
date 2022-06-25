package p300plus.p1312;

public class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] cs = s.toCharArray();
        for(int j = 0;j < len;j++){
            dp[j][j] = 1;
            for(int i = j - 1;i >= 0; i--){
                if(cs[i] == cs[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return len - dp[0][len - 1];
    }
}
