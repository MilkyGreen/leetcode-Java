package p100.p0080;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * <p>
 * Copyright: Copyright (c) 2020/7/30 19:45
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 思路：这题直接看答案了，真想。。。
     * 总体思路：遍历数组，把不超过两个的元素排到j的位置，超过2个的位置跳过。最终j位置前面都是不超过2相同的元素。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        // j前面都是符合要求的元素
        int j = 1;
        // 代表当前元素的重复次数，至少1次
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // 发现重复的，count加一
                count++;
            } else {
                // 找到了新元素，count重置为1
                count = 1;
            }

            if (count <= 2) {
                // 只把符合要求的元素移到j的位置，j相应加一
                nums[j] = nums[i];
                j++;
            }
        }

        // 最终j位置前面的都是 重复小于2次的元素
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(new Solution().removeDuplicates(nums));
    }

}
