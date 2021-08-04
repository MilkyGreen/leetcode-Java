package p300plus.p2041;

import java.util.LinkedList;

/**
 * <p>
 */
public class Solution {

    public String minNumber(int[] nums) {
        int l = nums.length;
        for(int i=0;i<l;i++){
            int max = 0;
            for(int j=0;j<l-i;j++){
                int k = nums[j];
                if(max(nums[max],k)){
                    max = j;
                }
            }
            int tmep= nums[max];
            nums[max] = nums[l-i-1];
            nums[l-i-1] = tmep;
        }
        String ans = "";
        for(int i:nums){
            ans+=i;
        }
        return ans;
    }
    //"1440424047126616733754888389576"
    // 1440424047126616733754888839576
    private boolean max(int max,int b){
        String ms = max+"";
        String bs = b+"";
        return (bs + ms).compareTo(ms +bs) > 0;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1440,7548,4240,6616,733,4712,883,8,9576};
//        int[] nums = new int[]{824,8247};
        new Solution().minNumber(nums);
    }

}
