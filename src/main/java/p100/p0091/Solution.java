package p100.p0091;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 */
public class Solution {

    /**
     * 看答案的思路：动态规划，从一个字符开始计算，每次可以加1或2个字符，取决于后面两个字符和否组合。另外还要考虑一些不合法的组合
     * ，如0 大于26 小于10 的这些。
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        int result = 0;
        if(s == null || s.length() == 0 || s.startsWith("0")){
            return result;
        }

        if(s.length() == 1){
            return 1;
        }

        char[] chars = s.toCharArray();

        int[] dp = new int[s.length()];
        dp[0] = 1;
        String s1 = (chars[0]+"") + (chars[1]+"") + "";

        if(Integer.parseInt(s1) <= 26 ){
            if(!(chars[1]+"").equals("0")){
                dp[1] = 2;
            }else {
                dp[1] = 1;
            }
        }else {
            if((chars[1]+"").equals("0")){
                return result;
            }else {
                dp[1] = 1;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            s1 = (chars[i-1]+"") + (chars[i]+"") + "";
            if(chars[i] == '0'){
                // 必须试图跟前面一个元素组合,大于26则不合法
                if(Integer.parseInt(s1) > 26 || Integer.parseInt(s1) == 0){
                    return result;
                }else {
                    dp[i] = dp[i - 2];
                }
            }else {
                if(Integer.parseInt(s1) > 26 || Integer.parseInt(s1) < 10){
                    // 组合不合法，只是在前面的方案后面加一个字母，方案数不变
                    dp[i] = dp[i - 1];
                }else {
                    // 可以组合，解决方案有两种：作为一个数加到前一个方案后面，即dp[i - 1]的方案数。
                    // 和i-1组合成一个数，跟在[i - 2]后面，相当于dp[i - 2]的方案数。两种方案数相加就是i的方案数
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }

        result = dp[s.length() - 1];
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int i = solution.numDecodings("301");
        System.out.println(i);
    }
}
