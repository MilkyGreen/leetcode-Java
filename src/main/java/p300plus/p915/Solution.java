package p300plus.p915;

public class Solution {
    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] maxs = new int[len];
        int[] mins = new int[len];
        int max = nums[0];
        int min = nums[len-1];
        for(int i = 0;i < len;i++){
            max = Math.max(nums[i],max);
            maxs[i] = max;
        }
        for(int i = len - 1;i >= 0;i--){
            min = Math.min(min,nums[i]);
            mins[i] = min;
        }

        for(int i = 0;i < len-1;i++){
            if(maxs[i] <= mins[i+1]){
                return i+1;
            }
        }
        return 0;
    }
}
