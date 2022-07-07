package p300plus.p525;

public class Solution {
    // 统计到每个i的时候，1和0的数量差值，缓存每个差值第一次出现的位置。如果i和j的差值一样，说明中间的一段1和0数量相当，可能为答案。
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int ret = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter,-1);
        for(int i = 0;i < n;i++){
            if(nums[i] == 1){
                counter++;
            }else{
                counter--;
            }
            if(map.containsKey(counter)){
                int len = i - map.get(counter);
                ret = Math.max(ret,len);
            }else{
                map.put(counter,i);
            }
        }
        return ret;
    }
}
