package p200.p179;

import java.util.Arrays;
import java.util.List;

/**
 */
public class Solution {
    // 字符串前后相加比较
    public String largestNumber(int[] nums) {

        String[] sarr = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            sarr[i] = nums[i]+"";
        }

        Arrays.sort(sarr, (s1, s2) -> {
            String sum1 = s1 + s2;
            String sum2 = s2 + s1;
            return sum1.compareTo(sum2);
        });

        String s = "";
        for(int i = sarr.length-1;i>=0;i--){
            if("".equals(s) && "0".equals(sarr[i])){
                continue;
            }
            s += sarr[i];
        }
        return "".equals(s) ? "0" : s;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12341,123411234};
        System.out.println(new Solution().largestNumber(nums));
    }

}
