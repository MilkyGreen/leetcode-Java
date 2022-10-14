package p100.p0080;

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int pre = nums[0];
        int len = 1;
        int i = 1;
        int idx = 1;
        while(i < nums.length){
            if(nums[i] == pre){
                len++;
            }else{
                pre = nums[i];
                len = 1;
            }
            
            if(len <= 2){
                nums[idx] = nums[i];
                idx++;
            }
            i++;
        }
        return idx;
    }
}
