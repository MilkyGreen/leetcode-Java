package p300plus.p334;

public class Solution2 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for(int i = 1;i < n;i++){
            int num = nums[i];
            if(num > second){
                return true;
            }
            if(num > first){
                second = num;
            }
            if(num < first){
                first = num;
            }
        }
        
        return false;
    }
}
