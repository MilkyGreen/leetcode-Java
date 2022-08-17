package p300plus.p1353;

public class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events,(a1,a2) -> {
            return a1[0] - a2[0];
        });
        int currDay = 1;
        int i = 0;
        int ret = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(i < n || pq.size() > 0){

            while(i < n && events[i][0] == currDay){
                pq.add(events[i][1]);
                i++;
            }

            while(pq.size() > 0 && pq.peek() < currDay){
                pq.remove();
            }

            if(pq.size() > 0){
                pq.remove();
                ret++;
            }
            currDay++;
        }
        return ret;

    }
}
