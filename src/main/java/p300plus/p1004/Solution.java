package p300plus.p1004;

public class Solution {
    public int longestOnes(int[] nums, int k) {

        int ret = 0;
        int left = 0;
        int right = 0;
        int zeroNum = 0;
        while(right < nums.length && left <= right){
            if(nums[right] == 0){
                zeroNum++;
            }
            while(zeroNum > k){
                if(nums[left] == 0){
                    zeroNum--;
                }
                left++;
            }
            ret = Math.max(ret,right - left + 1);
            right++;
        }
        return ret;
    }
}
