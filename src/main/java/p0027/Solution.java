package p0027;

/**
 * Created by simon on 2020/2/23.
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left<right){
            if(nums[right] == val){
                right--;
                continue;
            }
            if(nums[left] == val){
                nums[left] = nums[right];
                nums[right] = val;
                right--;
            }
            left++;
        }
        return nums[left] == val ? left:left+1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(solution.removeElement(nums,2));

    }

}
