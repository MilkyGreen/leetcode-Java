package p200.p153;

public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.min(nums[0],nums[1]);
        }
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            
            if(mid == 0 && nums[mid] < nums[mid + 1]){
                return nums[mid];
            }
            if(mid == len - 1 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(mid > 0 && mid < len - 1 && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]){
                return nums[mid];
            }
            
            // 二分，如果右边是升序，淘汰掉，否则淘汰左边的
            if(nums[mid] < nums[r]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return nums[0];
    }
}
