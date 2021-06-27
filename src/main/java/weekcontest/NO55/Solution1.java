package weekcontest.NO55;

import p300.p210.Solution;

/**
 */
public class Solution1 {

    public boolean canBeIncreasing(int[] nums) {
        boolean isDeleted = false;

        for (int i = 0; i < nums.length; i++) {
            if(i == nums.length-1) return true;
            if(nums[i] >= nums[i+1]){
                if(isDeleted) {
                    return false;
                }else {
                    // 判断删除 i 还是i+1,如果i+1小于i-1就要删除i+1,否则删除i
                    if(i != 0){
                        if(nums[i+1] <= nums[i-1]){
                            nums[i+1] = nums[i];
                        }else {
                            nums[i] = nums[i-1];
                        }
                    }
                    isDeleted = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] nums = {105,924,32,968};
        System.out.println(new Solution1().canBeIncreasing(nums));
    }

}
