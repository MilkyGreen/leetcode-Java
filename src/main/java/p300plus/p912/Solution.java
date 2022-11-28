package p300plus.p912;

public class Solution {
    public int[] sortArray(int[] nums) {
        
        sort(nums,0,nums.length-1);
        return nums;
    }

    public void sort(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int i = partition(nums, start, end);
        sort(nums,start,i-1);
        sort(nums,i+1,end);
    }

    public int partition(int[] nums,int start,int end){
        int len = end - start + 1;
        int pIdx = start + new Random().nextInt(len);

        int temp = nums[pIdx];
        nums[pIdx] = nums[end];
        nums[end] = temp;

        int p = nums[end];
        int idx = start;
        for(int i = start;i < end;i++){
            if(nums[i] < p){
                temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }

        temp = nums[end];
        nums[end] = nums[idx];
        nums[idx] = temp;

        return idx;
    }
}
