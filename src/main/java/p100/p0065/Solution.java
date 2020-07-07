package p100.p0065;

/**
 * 验证给定的字符串是否可以解释为十进制数字。
 * <p>
 * Copyright: Copyright (c) 2020/5/29 22:40
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 数字 0-9
     * 指数 - "e"
     * 正/负号 - "+"/"-"
     * 小数点 - "."
     */
    public boolean isNumber(String s) {

        if(s == null || s.length() == 0){
            return false;
        }

        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if('0' <= chars[i] && '9' >= chars[i]){
                numSeen = true;
            }else if('.' == chars[i]){
                if(dotSeen || eSeen){
                    return false;
                }else {
                    dotSeen = true;
                }
            }else if('e' == chars[i] || 'E' == chars[i]){
                if(eSeen || !numSeen){
                    return false;
                }else{
                    numSeen =false;
                    eSeen = true;
                }
            }else if('-' == chars[i] || '+' == chars[i]){
                if( i!=0 && chars[i-1] != 'e' && chars[i-1] != 'E'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return numSeen;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isNumber("6e-1"));
    }

}
