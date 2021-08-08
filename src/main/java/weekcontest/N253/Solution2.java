package weekcontest.N253;

import java.util.PriorityQueue;

/**
 * <p>
 */
public class Solution2 {


    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int pile : piles) {
            p.add(pile);
        }

        for (int i = 0; i < k; i++) {
            Integer poll = p.poll();
            p.add(poll - poll/2);
        }

        int ans = 0;
        while (p.size() > 0){
            ans += p.poll();
        }
        return ans;
    }

    public static void main(String[] args){
    }

}
