package weekcontest.NO60;

/**
 * <p>
 */
public class Solution {

    public static void main(String[] args) {

    }


    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if(left == sum-left-nums[i]){
                return i;
            }
            int num = nums[i];
            left += num;
        }

        return -1;
    }
}
