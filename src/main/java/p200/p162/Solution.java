package p200.p162;

//峰值元素是指其值大于左右相邻值的元素。
//
// 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。
//
// 示例 2：
//
//
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// -231 <= nums[i] <= 231 - 1
// 对于所有有效的 i 都有 nums[i] != nums[i + 1]
//
//
//
//
// 进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？
public class Solution {

    public int findPeakElement(int[] nums) {
        int l = nums.length;
        if(l == 1){
            return 0;
        }
        if(nums[0] > nums[1]){ // 第一个元素就是峰值
            return 0;
        }
        if(nums[l - 2] < nums[l - 1]){ // 最后一个是峰值
            return l - 1;
        }
        int left = 0;
        int right = l-1;
        while (left < right){ // 二分法，每次找到中间元素之后，与旁边比较谁更大，继续二分大的元素所在的一半，因为峰值肯定在大的一边。
            // 1 2 3 4 5
            // 1 2 3 4
            int mid = left+(right - left)/2; // mid，奇数的时候是正中间，偶数的时候偏右
            if(nums[mid+1] > nums[mid]){ // 这里与mid+1比较，因为只有两个元素的时候mid=0
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left; // 当left=right 时会跳出循环，即一个峰值了。
    }

    public static void main(String[] args){
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(new Solution().findPeakElement(nums));
    }
}
