package weekcontest.NO248;

/**
 * <p>
 */
public class Solution {

    public int[] buildArray(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];

        for (int i = 0; i < l; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {5,0,1,2,3,4};
        int[] ints = new Solution().buildArray(nums);
        for (int i : ints) {
            System.out.println(i);
        }

    }

}
