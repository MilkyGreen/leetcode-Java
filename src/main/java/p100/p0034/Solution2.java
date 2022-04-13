package p100.p0034;

public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                left = mid;
                right = mid;
                while(left > 0 && nums[left] == nums[left - 1]){
                    left--;
                }
                while(right < nums.length-1 && nums[right] == nums[right+1]){
                    right++;
                }
                break;
            }
        }
        return new int[]{left,right};
    }
}
