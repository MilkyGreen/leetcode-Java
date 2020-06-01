package p0069;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * <p>
 * Copyright: Copyright (c) 2020/6/1 22:30
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 主要用二分法，从0到x找平方等于或者小于x的最大值。
     * 注意点：和普通二分查找不通在于，答案不能靠相等确定，而是找小于的最接近的值，因此每次Mid平方小于x的时候，更新一下ans，
     * 大于x更新end的值，直到start>end结束循环，此时的ans就是最接近的答案。
     * 另外，mid*mid有可能超过int长度，需在等式那行转long，在外面转不起作用，原因待研究。
     * @param x
     * @return
     */
    public int mySqrt(int x) {

        int start = 0;
        int end = x;
        int mid = 0;
        int ans = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
//            long i = mid * mid;
            if ((long)mid * mid == x) {
                return mid;
            } else if ((long)mid * mid > x) {
                /*if((mid -1)*(mid -1) <= x ){
                    return mid -1;
                }*/

                end = mid-1;
            } else {
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }

}
