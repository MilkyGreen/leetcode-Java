package p300plus.p581;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1){
            return 0;
        }
        int ret = 0;
        int max = nums[0];
        int rightRange = 0;
        for(int i =1;i < len;i++){
            if(nums[i] < max){
                rightRange = i;
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int min = nums[len - 1];
        int leftRange = 0;
        for(int i = len - 2;i >= 0;i--){
            if(nums[i] > min){
                leftRange = i;
            }
            min = Math.min(min,nums[i]);
        }
        return leftRange == rightRange ? 0 : rightRange - leftRange + 1;
    }
}