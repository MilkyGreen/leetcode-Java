package p300plus.p303;

public class Solution {
    int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length+1];
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            sums[i+1] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }
}
