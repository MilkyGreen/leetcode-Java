package p300plus.p2224;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 */
public class Solution {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        ret.add(winners);
        ret.add(losers);

        Map<Integer,int[]> map = new TreeMap<>();
        for(int[] m : matches){
            int winner = m[0];
            int loser = m[1];
            int[] wr = map.getOrDefault(winner,new int[2]);
            wr[0] = wr[0]+1;
            map.put(winner,wr);

            int[] lr = map.getOrDefault(loser,new int[2]);
            lr[1] = lr[1]+1;
            map.put(loser,lr);
        }

        for(Map.Entry<Integer,int[]> e : map.entrySet()){
            Integer p = e.getKey();
            int[] r = e.getValue();
            if(r[0] >= 1 && r[1] == 0){
                winners.add(p);
            }
            if(r[1] == 1){
                losers.add(p);
            }
        }
        //winners.sort();
        //losers.sort();

        return ret;
    }

}
