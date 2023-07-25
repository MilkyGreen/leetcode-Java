package p300plus.p950;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        LinkedList<Integer> dqueue = new LinkedList<>();
        for(int i = len -1;i >= 0;i--){
            if(dqueue.size() > 0){
                dqueue.addFirst(dqueue.removeLast());
            }
            dqueue.addFirst(deck[i]);
        }
        int[] res = new int[len];
        for(int i = 0;i < len;i++){
            res[i] = dqueue.removeFirst();
        }

        return res;

    }
}
