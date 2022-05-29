package p200.p154;

public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = left + ((right - left) >> 1);

            while(nums[left] == nums[mid] && left < mid){
                left++;
            }

            if(nums[left] <= nums[mid]){
                while(nums[right] == nums[mid] && mid < right){
                    right--;
                }

                if(nums[mid] > nums[right]){
                    left = mid+1;
                }else{
                    return nums[left];
                }

            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
