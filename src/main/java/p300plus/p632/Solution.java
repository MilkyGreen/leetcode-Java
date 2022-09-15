package p300plus.p632;

public class Solution {
    /**
     * 数字和组组成pair，排序，滑动窗口保持k个组都在
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> all = new ArrayList<>();
        int k = nums.size();
        for(int i = 0;i < nums.size();i++){
            List<Integer> line = nums.get(i);
            for(int n : line){
                all.add(new int[]{n,i});
            }
        }
        all.sort((a1,a2) -> a1[0] - a2[0]);

        int minStart = all.get(0)[0];
        int minEnd = all.get(all.size()-1)[0];
        int minLen = minEnd - minStart;

        Map<Integer,Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < all.size()){
            int[] l = all.get(left);
            int[] r = all.get(right);
            while(right < all.size() && count.size() < k){
                r = all.get(right);
                count.put(r[1],count.getOrDefault(r[1],0)+1);
                right++;
            }
            if(count.size() < k){
                break;
            }
            if(r[0] - l[0] < minLen ){
                minStart = l[0];
                minEnd = r[0];
                minLen = r[0] - l[0];
            }

            while(left < right && count.size() == k){
                l = all.get(left);
                if(r[0] - l[0] < minLen ){
                    minStart = l[0];
                    minEnd = r[0];
                    minLen = r[0] - l[0];
                }
                count.put(l[1],count.get(l[1]) - 1);
                if(count.get(l[1]) == 0){
                    count.remove(l[1]);
                }
                left++;
            }
        }
        return new int[]{minStart,minEnd};

    }
}
