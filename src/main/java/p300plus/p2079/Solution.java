package p300plus.p2079;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p>
 */
public class Solution {

    public int strToInt(String str) {
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        char[] cs = str.toCharArray();
        long res = 0L;
        if((cs[0] != '-' && cs[0] != '+') && ( cs[0] < '0' || cs[0] > '9')){
            return 0;
        }

        char pos = ' ';
        if (cs[0] == '-' || cs[0] == '+') {
            pos = cs[0];
        }else {
            res = Integer.valueOf(cs[0]+"");
        }
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                res = res * 10 + Integer.valueOf(cs[i]+"");
                if(pos == '-'){
                    if(res >= (long)Integer.MAX_VALUE+1){
                        return Integer.MIN_VALUE;
                    }
                }else {
                    if(res >= Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        int l = (int)(pos == '-' ? -res : res);
        return l;
        /*
        int num;
        if (pos == '-') {
            if (String.valueOf(Integer.MIN_VALUE).length()-1 < sb.length()) {
                return Integer.MIN_VALUE;
            } else if (String.valueOf(Integer.MIN_VALUE).length()-1 == sb.length()) {
                int i = String.valueOf(Integer.MIN_VALUE).substring(1).compareTo(sb.toString());
                if (i <= 0) {
                    return Integer.MIN_VALUE;
                }
            }
            num = -(int)Long.parseLong(sb.toString());
        } else {
            if (String.valueOf(Integer.MAX_VALUE).length() < sb.length()) {
                return Integer.MAX_VALUE;
            } else if (String.valueOf(Integer.MAX_VALUE).length() == sb.length()) {
                int i = String.valueOf(Integer.MAX_VALUE).compareTo(sb.toString());
                if (i <= 0) {
                    return Integer.MAX_VALUE;
                }
            }
            num = Integer.parseInt(sb.toString());
        }
        return num;*/
    }

    public static void main(String[] args) {
//        new Solution().strToInt("42");
//        new Solution().strToInt("-42");
//        new Solution().strToInt("4193 with words");
        System.out.println(new Solution().strToInt("2147483648"));
//        System.out.println(new Solution().strToInt("    000000   00"));
    }

}
