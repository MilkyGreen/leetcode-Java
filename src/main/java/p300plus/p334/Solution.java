package p300plus.p334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        boolean[] hasRightBigger = new boolean[n];
        int rightMax = nums[n-1];
        for(int i = n-1;i>=0;i--){
            if(nums[i] < rightMax){
                hasRightBigger[i] = true;
            }else{
                rightMax = nums[i];
            }
        }

        int leftMin = nums[0];
        for(int i = 1;i < n;i++){
            if(nums[i] > leftMin){
                if(hasRightBigger[i]){
                    return true;
                }
            }else{
                leftMin = nums[i];
            }
        }
        return false;
    }
}
