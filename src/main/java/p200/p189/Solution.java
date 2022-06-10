package p200.p189;

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if(k == 0){
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k,len - 1);
    }

    public void reverse(int[] nums,int left,int right){
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
