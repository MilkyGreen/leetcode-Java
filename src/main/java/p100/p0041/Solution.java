package p100.p0041;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/18 22:40
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {

        if(nums == null || nums.length == 0){
            return 1;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if(i+1 != nums[i]){
                return i+1;
            }
        }
        return n+1;
    }

}
