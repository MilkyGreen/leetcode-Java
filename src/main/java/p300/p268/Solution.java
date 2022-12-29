package p300.p268;

public class Solution {
    public int missingNumber(int[] nums) {
        boolean hasN = false;
        int n = nums.length;
        
        for(int i = 0;i < n;i++){
            int v = 0;
            if(nums[i] > n){
                v = nums[i] - (n+1);
            }else{
                v = nums[i];
            }

            if(v == n){
                hasN = true;
            }else{
                nums[v] = nums[v] + n + 1;
            }
        }

        if(!hasN){
            return n;
        }else{
            for(int i = 0;i < n;i++){
                if(nums[i] <= n){
                    return i;
                }
            }
        }
        return 0;
    }
}
