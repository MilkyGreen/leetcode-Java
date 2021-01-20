package p200.p128;

import java.util.HashSet;
import java.util.Set;

/**
 * //给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * //
 * //
 * //
 * // 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [100,4,200,1,3,2]
 * //输出：4
 * //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * //输出：9
 * //
 * //
 * //
 * //
 */
public class Solution {

    public int longestConsecutive(int[] nums) {

        int ans = 0;
        Set<Integer> numSet = new HashSet<>(); // 放进set中去重
        for (int num : nums) {
            numSet.add(num);
        }

        // 遍历每个元素
        for (Integer curr : numSet) {
            int currLongest = 1; // 当前长度是1，即数字本身

            // 如果存在x-1,则没有必要判断x，因为x-1的序列肯定比x长
            if(!numSet.contains(curr - 1)){
                while (numSet.contains(curr+1)){ // 如果存在下一个数字，继续往下寻找next，当前长度+1
                    currLongest++;
                    curr++;
                }
                ans = Math.max(ans,currLongest); // 每次取一下最大长度
            }
        }
        return ans;
    }


    public static void main(String[] args){
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int i = new Solution().longestConsecutive(nums);
        System.out.println(i);
    }
}
