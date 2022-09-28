package p100.p0027;

public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for(int n : nums){
            if(n != val){
                nums[idx] = n;
                idx++;
            }
        }
        return idx;
    }
}
