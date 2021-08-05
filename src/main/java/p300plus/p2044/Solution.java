package p300plus.p2044;

import java.util.*;

/**
 * <p>
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int l = cs.length;
        if(s.length() == 0){
            return 0;
        }
        int ans=1;
        int[] dp = new int[l];
        dp[0] = 1;
        map.put(cs[0],0);
        for(int i=1;i<l;i++){
            int j = map.getOrDefault(cs[i],-1);
            map.put(cs[i],i);
            dp[i] = i-j > dp[i-1]? dp[i-1]+1 : i-j;
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().nthUglyNumber(1432));

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> (int)o2-(int)o2));
        pq.add(1);
        pq.add(3);
        pq.add(4);
        pq.add(2);

        while (pq.size() > 0){
            System.out.println(pq.peek());
            System.out.println(pq.poll());
        }
    }

    public int nthUglyNumber(int n) {
        if(n <= 6){
            return n;
        }
        Set<Long> set = new HashSet<>();
        set.add(1L);
        PriorityQueue<Long> pq = new PriorityQueue<>(n);
        pq.add(1L);
        int ug = 0;
        for (int i = 0; i < n; i++) {
            long curr = pq.poll();
            ug = (int) curr;
            if(!set.contains(curr*2)){
                pq.add(curr*2);
                set.add(curr*2);
            }
            if(!set.contains(curr*3)){
                pq.add(curr*3);
                set.add(curr*3);
            }
            if(!set.contains(curr*5)){
                pq.add(curr*5);
                set.add(curr*5);
            }
        }
        return ug;
    }
    /*int[] factors = {2, 3, 5};
    Set<Long> seen = new HashSet<Long>();
    PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
    int ugly = 0;
        for (int i = 0; i < n; i++) {
        long curr = heap.poll();
        ugly = (int) curr;
        for (int factor : factors) {
            long next = curr * factor;
            if (seen.add(next)) {
                heap.offer(next);
            }
        }
    }
        return ugly;*/

}
