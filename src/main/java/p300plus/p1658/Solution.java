package p300plus.p1658;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        int count = sum - x;
        if(count < 0){
            return -1;
        }
        if(count == 0){
            return len;
        }
        int maxLen = 0;
        boolean hasAns = false;
        int winSum = 0;
        while(right < len){
            winSum += nums[right];

            while(left <= right && winSum > count){
                winSum -= nums[left];
                left++;
            }

            if(winSum == count){
                hasAns = true;
                maxLen = Math.max(maxLen,right - left + 1);
            }

            right++;
        }

        return hasAns ? len - maxLen : -1;
        
    }
}
