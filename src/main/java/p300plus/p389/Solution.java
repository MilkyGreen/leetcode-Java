package p300plus.p389;

public class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    public Solution(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            int v = nums[i];
            List<Integer> list = map.getOrDefault(v,new ArrayList());
            list.add(i);
            map.put(v,list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(new Random().nextInt(list.size()));
    }
}
