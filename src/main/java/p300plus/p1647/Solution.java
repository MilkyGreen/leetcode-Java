package p300plus.p1647;

public class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        Map<Character,Integer> counter = new HashMap<>();
        Map<Integer,Integer> fCounter = new HashMap<>();
        for(char c : s.toCharArray()){
            counter.put(c,counter.getOrDefault(c,0)+1);
        }

        for(int i : counter.values()){
            fCounter.put(i,fCounter.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> e : fCounter.entrySet()){
            pq.offer(new int[]{e.getKey(),e.getValue()});
        }

        int ret = 0;
        while(pq.size() > 0){
            int[] max = pq.poll();
            if(max[1] > 1){
                ret += max[1] - 1;
                int[] peek = pq.peek();
                if(peek != null && peek[0] == (max[0]-1)){
                    peek[1] +=  max[1] - 1;
                    pq.poll();
                    pq.offer(peek);
                }else{
                    if(max[0] - 1 > 0){
                        pq.offer(new int[]{max[0] - 1,max[1] - 1});
                    }
                    
                }
            }
        }
        return ret;
    }
}
