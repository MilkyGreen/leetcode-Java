package p0067;


import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * Copyright: Copyright (c) 2020/5/31 21:24
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 很直观的想法，逐个相加，大于等于2向前进位。
     * 代码略丑陋，速度慢，懒得优化了。。。
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {


        //a = "1010", b = "1011"
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int al = aChars.length;
        int bl = bChars.length;
        int max = Math.max(al, bl);

        char[] longer;
        char[] shorter;
        int longl;
        int shortl;
        int diff = Math.abs(al - bl);
        if(al > bl){
            longer = aChars;
            shorter = bChars;
            longl = al;
            shortl = bl;
        }else {
            longer = bChars;
            shorter = aChars;
            longl = bl;
            shortl = al;
        }
//        List<Integer> ansList = new ArrayList<>();
StringBuilder sb = new StringBuilder();
        boolean needExpend = false;
        for (int i = 0; i < longl; i++) {
            if(i < shortl){
                char aChar = longer[longl - 1 - i];
                Integer aInt = Integer.valueOf(String.valueOf(aChar));
                char bChar = shorter[shortl - 1 - i];
                Integer bInt = Integer.valueOf(String.valueOf(bChar));
                int sumInt = needExpend ? 1+aInt + bInt:aInt + bInt;
                if(sumInt >= 2 ){
                    sb.append(sumInt - 2);
                    needExpend = true;
                }else{
                    sb.append(sumInt);
                    needExpend = false;
                }
            }else{
                char c = longer[longl - 1 - i];
                Integer aInt = Integer.valueOf(String.valueOf(c));
                int sum = needExpend ? 1+aInt:aInt;
                if(sum == 2){
                    sb.append(0);
                    needExpend = true;
                }else {
                    sb.append(sum);
                    needExpend = false;
                }
            }

        }
        if(needExpend){
            sb.append(1);
        }

        /*for (int i = ansList.size() -1; i >= 0; i--) {
            sb.append(ansList.get(i));
        }*/
        return sb.reverse().toString();

        /*char[] longer;
        int diff = Math.abs(al - bl);
        if(al == bl){
            if(needExpend){
                sb.append(1);
            }
        }else if(al > bl){
            longer = aChars;
        }else {
            longer = bChars;
        }
        if(diff > 0){
            for (int i = diff - 1; i >= 0; i--) {
                if(needExpend){

                }
                sb.append()
            }
        }*/

    }

    public static void main(String[] args){
        String a = "1";
        String b = "11";
        Solution solution = new Solution();
        System.out.println(solution.addBinary(a,b));
    }

}
