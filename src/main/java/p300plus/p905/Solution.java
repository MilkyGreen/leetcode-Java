package p300plus.p905;

public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int nextEven = 0;

        for(int i = 0;i < len;i++){
            if(nums[i] % 2 == 0){
                int tmp = nums[i];
                nums[i] = nums[nextEven];
                nums[nextEven] = tmp;
                nextEven++;
            }
        }
        return nums;
    }
}
