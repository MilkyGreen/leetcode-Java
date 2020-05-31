package p0066;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * Copyright: Copyright (c) 2020/5/30 22:29
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 给最后一位加一，如果等于10则需要进位，往前加一，直到不用进位。
     * 如果第一个元素也要进位，则数组扩张一位，第一位等于1。
     * -> 击败100% Java
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] ans = digits;
        int l = digits.length;
        boolean needExpand = false;
        for (int i = l-1; i >= 0; i--) {
            int digit = digits[i];
            if(digit < 9){
                digits[i] += 1;
                return ans;
            }else{
                digits[i] = 0;
                needExpand = true;
            }
        }
        if(needExpand){
            ans = new int[l+1];
            ans[0] = 1;
            System.arraycopy(digits,0,ans,1,l);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] digits = {9,9,9};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(digits)));
    }
}
