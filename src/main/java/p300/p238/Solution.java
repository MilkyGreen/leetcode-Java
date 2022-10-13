package p300.p238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        int prods = 1;
        for(int i = 0;i < len;i++){
            prods *= nums[i];
            ret[i] = prods;
        }
        prods = nums[len - 1];
        ret[len-1] = ret[len-2];
        for(int i = len-2;i > 0;i--){
            ret[i] = prods * ret[i-1];
            prods *= nums[i];
        }
        ret[0] = prods;
        return ret;
    }
}
