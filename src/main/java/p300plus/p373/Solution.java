package p300plus.p373;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]+a[1]) - (b[0]+b[1]));

        for(int i = 0;i < nums1.length;i++){
            pq.offer(new int[]{nums1[i],nums2[0],0});
        }

        List<List<Integer>> ret = new ArrayList<>();

        while(k-- > 0 && pq.size() > 0){
            int[] curr = pq.poll();
            ret.add(Arrays.asList(curr[0],curr[1]));

            if(curr[2] == nums2.length-1){
                continue;
            }

            pq.offer(new int[]{curr[0],nums2[curr[2]+1],curr[2]+1});
        }

        return ret;
    }
}
