package p300plus.p1031;

public class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int len = nums.length;
        int[] sums = new int[len+1];
        for(int i = 1;i <= len;i++){
            sums[i] = nums[i-1] + sums[i-1];
        }
        int ret = 0;
        for(int i = 0;i <= len - firstLen - secondLen;i++){
            for(int j = i + firstLen;j <= len - secondLen;j++){
                int firstSum = sums[i+firstLen] - sums[i];
                int secondSum = sums[j+secondLen] - sums[j];
                ret = Math.max(ret,firstSum + secondSum);
            }
        }

        for(int i = 0;i <= len - secondLen - firstLen;i++){
            for(int j = i + secondLen;j <= len - firstLen;j++){
                int firstSum = sums[i+secondLen] - sums[i];
                int secondSum = sums[j+firstLen] - sums[j];
                ret = Math.max(ret,firstSum + secondSum);
            }
        }
        return ret;
    }
}
