package p0055;

/**
 * @author liyunmeng
 * @Description: 跳跃游戏
 * @Date 2020/4/22 22:37
 */
public class Solution {

    /**
     * 数组中有0才会导致失败。遇到0时判断前面是否有元素能跨过0，有的话就可以忽略这个0，否则失败
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0){
                    boolean curr= false;
                    for (int j = 0; j < i; j++) {
                        if(nums[j] + j > i || (nums[j] + j == nums.length-1)){
                            curr = true;
                            break;
                        }
                    }
                    if(!curr){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {3,2,1,0,4};
        System.out.println(solution.canJump(nums));
    }

}
