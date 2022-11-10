package p300plus.p697;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> numAppare = new HashMap<>();
        Map<Integer,Integer> counts = new HashMap<>();
        int degree = 1;
        int ret = 1;
        for(int i =0;i < nums.length;i++){
            int n = nums[i];
            if(!numAppare.containsKey(n)){
                numAppare.put(n,i);
            }
            counts.put(n,counts.getOrDefault(n,0)+1);
            int count = counts.get(n);
            if(count == degree){
                ret = Math.min(ret,i - numAppare.get(n) + 1);
            }else if(count > degree){
                degree = count;
                ret = i - numAppare.get(n) + 1;
            }
        }
        return ret;
    }
}
