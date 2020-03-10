package p0026;

/**
 * Created by simon on 2020/2/23.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[curr] != nums[i]){
                curr++;
                nums[curr] = nums[i];
            }
        }
        return curr+1;
    }

    public static void main(String[] args){
        int[] nums= {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution().removeDuplicates(nums));
    }

}
