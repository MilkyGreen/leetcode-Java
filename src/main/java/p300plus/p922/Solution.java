package p300plus.p922;

public class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        int evenIdx = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] % 2 == 0){
                if(i % 2 == 0){
                    continue;
                }
                while(nums[evenIdx] % 2 == 0){
                    evenIdx += 2;
                }
                swap(nums,i,evenIdx);
                evenIdx += 2;
            }
        }
        return nums;
    }

    void swap(int[] nums,int a ,int b){
        int tmep = nums[a];
        nums[a] = nums[b];
        nums[b] = tmep;
    }
}
