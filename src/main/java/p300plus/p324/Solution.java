package p300plus.p324;

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] newNums = new int[nums.length];
        for(int i = 0;i < len;i++){
            newNums[i] = nums[i];
        }

        int leftStart = len % 2 == 0 ? len / 2 - 1: len/2;
        int rightStart = len - 1;

        int i = leftStart;
        int j = rightStart;
        int idx = 0;
        while(j > leftStart){
            nums[idx++] = newNums[i--];
            nums[idx++] = newNums[j--];
        }

        if(len % 2 != 0){
            nums[idx++] = newNums[i];
        }

    }
}
