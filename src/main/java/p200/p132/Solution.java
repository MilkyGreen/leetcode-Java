package p200.p132;

/**
 * //给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * //
 * // 返回符合要求的最少分割次数。
 * //
 * // 示例:
 * //
 * // 输入: "aab"
 * //输出: 1
 * //解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * //
 */
public class Solution {

    /**
     * 沿用上一题思路，这次只计算次数？  果然超时了。。。
     *
     * @param s
     * @return
     */
    /*public int minCut1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        res = s.length()-1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            preDetermine(dp,s,i,i);
            preDetermine(dp,s,i,i+1);
        }
        dfs(0,s,dp,0);
        return res;
    }

    int res;
    private void dfs(int currentCut,String s,boolean[][] dp,int start){
        if(start == s.length()){ // 只剩最后一个字符，肯定是回字串，也就不用再判断了
            res = Math.min(res,currentCut-1);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(dp[start][i]){
                currentCut++;
                dfs(currentCut,s,dp,i+1);
                currentCut--;
            }
        }
    }*/


    public static void main(String[] args){
        int aab = new Solution().minCut("aab");
        System.out.println(aab);
    }


    /**
     * 思路：动态规划 dp[i] 代表0到i回字最小切割数，假如dp[j+1][i] 是回字串，则dp[i]=dp[j]+1
     * @param s
     * @return
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean[][] can = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            preDetermine(can,s,i,i);
            preDetermine(can,s,i,i+1);
        }

        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }

        for (int i = 1; i < s.length(); i++) {
            if(can[0][i]){
                dp[i] = 0;
            }else {
                for (int j = 1; j <= i; j++) {
                    if(can[j][i]){ // 要保证算到can[i][i] ，肯定是回文，然后计算一次dp[i]
                        dp[i] = Math.min(dp[j-1]+1,dp[i]);
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
    private void preDetermine(boolean[][] can, String s, int start, int end) {
        if (start > end || start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end)) {
            return;
        }
        can[start][end] = true;
        preDetermine(can,s,start-1,end+1);
    }

}
