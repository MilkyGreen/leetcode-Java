package p100.p0055;

/**
 * 两年后面对同样的题（Solution.java），只能说我已不是当时的我 :)
 */
public class Solution2 {
    public boolean canJump(int[] nums) {
        // 最大到达位置
        int maxD = 0;
        for(int i = 0;i < nums.length-1; i++){
            // 遇到0时看看前面最大到达位置能否跨过0
            if(nums[i] == 0){
                if(maxD <= i){
                    return false;
                }
            }else{
                maxD = Math.max(maxD,i + nums[i]);
            }
        }
        // 最大位置是否能到尾部
        return maxD >= nums.length-1 ? true : false;
    }
}
