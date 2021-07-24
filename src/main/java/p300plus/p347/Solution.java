package p300plus.p347;

import java.util.*;

/**
 * <p>
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        if(k ==0){
            return new int[]{0};
        }
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> pq =new PriorityQueue<>(k, Comparator.comparingInt(o -> o[1]));
        for(Map.Entry<Integer,Integer> e : count.entrySet()) {
            int v = e.getKey();
            int c = e.getValue();
            if(pq.size() < k){
                pq.add(new int[]{v,c});
            }else{
                if(pq.peek()[1] < c){
                    pq.poll();
                    pq.add(new int[]{v,c});
                }
            }
        }
        int[] ans = new int[k];
        for(int i = 0;i < k;i++){
            ans[i] = pq.poll()[0];
        }

        return ans;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        System.out.println(pq.peek());
    }
}
