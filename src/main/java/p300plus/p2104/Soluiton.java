package p300plus.p2104;

public class Soluiton {
    public long subArrayRanges(int[] nums) {
        long ret = 0;
        int len = nums.length;
        for(int i = 0;i < len;i++){
            int max = nums[i];
            int min = nums[i];
            int right = i + 1;
            while(right < len){
                max = Math.max(max,nums[right]);
                min = Math.min(min,nums[right]);
                ret += max - min;
                right++;
            }
        }
        return ret;
    }
}
