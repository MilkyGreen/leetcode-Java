package p0043;

import java.lang.reflect.Array;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/27 23:00
 */
public class Solution {

    public String multiply(String num1, String num2) {

        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        int l1 = num1.length();
        char[] l1Chars = num1.toCharArray();
        char[] l2Chars = num2.toCharArray();
        int l2 = num2.length();

        // 保存每次相乘的结果，个位在最右
        int[] ans = new int[l1 + l2];
        for (int i = l1-1; i >= 0; i--) {
            int c = l1Chars[i] - '0';
            for (int j = l2 - 1; j >= 0; j--) {
                int cc = l2Chars[j] - '0';
                ans[i + j + 1] += c*cc;
            }
        }

        // 从右开始发现大于9的向左进位
        for (int i = ans.length - 1; i >=0; i--) {
            if(ans[i] > 9){
                ans[i - 1] += ans[i]/10;
                ans[i] = ans[i]%10;
             }
        }

        // 寻找最高位，也就是数组中第一个不为0的位置
        int i = 0;
        for (; i < ans.length; i++) {
            if(ans[i] != 0){
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        for ( ;i < ans.length; i++) {
            sb.append(ans[i]);

        }
        return sb.toString();

    }


    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.multiply("123","456"));
    }

}
