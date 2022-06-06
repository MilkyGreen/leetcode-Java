package p300.p264;

public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        Set<Long> seen = new HashSet<>();
        pq.offer(1L);
        seen.add(1L);
        long u = 1;
        int[] fs = new int[]{2,3,5};
        for(int i = 0;i < n;i++){
            u = pq.poll();
            for(int f : fs){
                if(!seen.contains(u * f)){
                    pq.add(u * f);
                    seen.add(u * f);
                }
                
            }
        }
        return (int)u;
    }
}
