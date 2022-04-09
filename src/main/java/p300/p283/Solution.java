package p300.p283;

public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int n : nums){
            if(n != 0){
                nums[i] = n;
                i++;
            }
        }
        for(;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}
