package p300plus.p910;

public class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ret = nums[n-1] - nums[0];
        for(int i=0;i < n-1;i++){
            int a = nums[i] + k;
            int b = nums[i+1] - k;
            int min = Math.min(nums[0]+k,b);
            int max = Math.max(nums[n-1]-k,a);
            ret = Math.min(ret,max-min);
        }
        return ret;
    }
}
