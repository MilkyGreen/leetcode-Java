package p300plus.p1005;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int len = nums.length;
        while(i < len && k > 0){
            if(nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }else{
                break;
            }
            i++;
        }
        if(k > 0){
            Arrays.sort(nums);
            if(k % 2 != 0){
                nums[0] = -nums[0];
            }
        }
        int ret = 0;
        for(int n : nums){
            ret += n;
        }
        return ret;
    }
}
