package p100.p0045;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/31 11:17
 */
public class Solution {
    public int jump(int[] nums) {

        int ans = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max,nums[i] + i);
            if(i == end){
                end = max;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums={2,3,1,1,4};
        System.out.println(new Solution().jump(nums));
    }
}
