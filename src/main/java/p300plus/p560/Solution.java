package p300plus.p560;

public class Solution {
    // 前缀和 + 哈希表。计算前缀和但是只记录每个和出现的次数
    public int subarraySum(int[] nums, int k) {
        int ret = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int n : nums){
            sum += n;
            if(map.containsKey(sum - k)){
                ret += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ret;
    }
}
