package p100.p0042;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/26 22:56
 */
public class Solution {

    public int trap(int[] height) {

        int ans = 0;
        if(height.length == 0){
            return ans;
        }

        int max = 0;
        for (int i = 1; i < height.length; i++) {
            if(height[max] < height[i]){
                max = i;
            }
        }
        int leftTmp= height[0];
        for (int i = 1; i < max; i++) {
            if(leftTmp > height[i]){
                ans+=leftTmp-height[i];
            }else{
                leftTmp = height[i];
            }
        }

        int rightTmp= height[height.length - 1];
        for(int i = height.length - 2;i > max;i--){
            if(rightTmp > height[i]){
                ans+=rightTmp-height[i];
            }else{
                rightTmp = height[i];
            }
        }
        return ans;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(nums));
    }

}
