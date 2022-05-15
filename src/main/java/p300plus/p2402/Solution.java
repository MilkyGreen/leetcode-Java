package p300plus.p2402;

public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroNum = 0;
        int pre = 0;
        int i = 0;
        while(i < nums.length){
            int n = nums[i];
            if(n == 0){
                zeroNum++;
                i++;
            }else{
                if(pre == 0){
                    pre = n;
                    i++;
                }else{
                    if(n != pre+1){
                        if(zeroNum > 0){
                            zeroNum--;
                        }else{
                            return false;
                        }
                    }else{
                        i++;
                    }
                    pre++;
                }
            }
        }
        return true;
    }
}
