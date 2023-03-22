package p300plus.p451;

public class Solution {
    Map<Character,Integer> count = new HashMap<>();
        char[] cs = s.toCharArray();
        for(char c : cs){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<Character>((c1,c2) -> {
            return count.get(c2) - count.get(c1);
        });
        for(Character c : count.keySet()){
            pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            char c = pq.poll();
            for(int i = 0;i < count.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
}
