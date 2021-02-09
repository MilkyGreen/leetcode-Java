package p200.p152;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4,-2,-5]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
public class Solution {

    /**
     * 思路： 遇到0或负数乘机会变小，所以寻找负数和0中间的正数区间，看看谁的乘积更大就行了。  --> 忘了负负得正
     *
     * 思路2：遇到0会变0，遇到奇数负数结果为负，偶数负数为正。
     * 分别从左右两边计算最大值，遇到0重置，最后比较最大的。
     *
     *
     * 当一个数组中没有0存在，则分为两种情况：
     *
     * 1.负数为偶数个，则整个数组的各个值相乘为最大值；
     *
     * 2.负数为奇数个，则从左边开始，乘到最后一个负数停止有一个“最大值”，从右边也有一个“最大值”，比较，得出最大值。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int res = nums[0];
        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            curr *= nums[i];
            res = Math.max(res,curr);
            if(nums[i] == 0){
                curr = 1;
            }
        }

        curr = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            curr *= nums[i];
            res = Math.max(res,curr);
            if(nums[i] == 0){
                curr = 1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,3,-2,4};
        int i = solution.maxProduct(nums);
        System.out.println(i);
    }

}
