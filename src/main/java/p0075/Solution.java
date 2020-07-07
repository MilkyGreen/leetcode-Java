package p0075;

import java.util.HashMap;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * @version 1.0.0
 */
public class Solution {

    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        Integer red = map.getOrDefault(0,0);
        for (Integer i = 0; i < red; i++) {
            nums[i] = 0;
        }

        Integer white = map.getOrDefault(1,0);
        for (Integer i = 0; i < white; i++) {
            nums[i+red] = 1;
        }

        Integer blue = map.getOrDefault(2,0);
        for (Integer i = 0; i < blue; i++) {
            nums[i+red+white] = 2;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,0,2,1,1,0};
        solution.sortColors2(nums);
        for (int num : nums) {
            System.out.print(num+"\t");
        }
    }

    /**
     * 正确思路：zeroIndex代表0的右边界，twoIndex代表2的左边界，中间的是1。curr代表当前遍历的位置。
     * 如果curr=0 和zeroIndex交换 zeroIndex++，如果curr=2和twoIndex交换 twoIndex--
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int curr = 0;

        while (curr <= twoIndex){
            if(nums[curr] == 0){
                int temp = nums[zeroIndex];
                nums[zeroIndex] = nums[curr];
                nums[curr] = temp;
                zeroIndex++;
                curr++;
            }else if(nums[curr] == 2){
                int temp = nums[twoIndex];
                nums[twoIndex] = nums[curr];
                nums[curr] = temp;
                twoIndex--;
            }else {
                curr++;
            }
        }

    }

}
