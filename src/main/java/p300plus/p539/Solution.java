package p300plus.p539;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String tp : timePoints){
            pq.offer(convert2Mins(tp));
        }
        int min = pq.poll();
        int pre = min;
        int ret = 24 * 60;
        while(pq.size() > 0){
            int curr = pq.poll();
            ret = Math.min(curr - pre,ret);
            pre = curr;
        }
        ret = Math.min(min + 24*60 - pre,ret);
        return ret;
    }

    int convert2Mins(String timePoint){
        String[] times = timePoint.split(":");
        int mins = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        return mins;
    }
}
