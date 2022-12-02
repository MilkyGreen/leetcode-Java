package p300plus.p1493;

public class Solution {
    public int longestSubarray(int[] nums) {
        Map<Integer,Integer> startMap = new HashMap<>();
        Map<Integer,Integer> endMap = new HashMap<>();
        int ret = 0;
        int oneLen = 0;
        int oneStart = 0;
        int pre = 0;
        boolean hasZero = false;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){
                if(pre == 0){
                    oneStart = i;
                }
                oneLen++;
                ret = Math.max(ret,oneLen);
            }else{
                hasZero = true;
                if(pre == 1){
                    startMap.put(oneStart,oneLen);
                    endMap.put(i-1,oneLen);
                }
                oneLen = 0;
            }
            pre = nums[i];
        }

        if(pre == 1){
            startMap.put(oneStart,oneLen);
            endMap.put(nums.length-1,oneLen);
        }

        for(int i = 1;i < nums.length-1;i++){
            if(nums[i] == 0 && nums[i-1] == 1 && nums[i+1] == 1){
                ret = Math.max(endMap.get(i-1)+startMap.get(i+1),ret);
            }
        }
        return hasZero ? ret : ret - 1;
    }
}
