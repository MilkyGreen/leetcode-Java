package weekcontest.NO256;

import java.util.Arrays;

/**
 * <p>
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = new int[]{9,4,1,7};
        System.out.println(new Solution().minimumDifference(nums,2));
    }


    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length == 1){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = k-1; i < nums.length; i++) {
            res = Math.min(res,nums[i]-nums[i-k+1]);
        }
        return res;
    }
}
