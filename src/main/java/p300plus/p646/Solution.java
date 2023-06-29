package p300plus.p646;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[0] - b[0]);

        Map<int[],Integer> longestCount = new HashMap<>();
        int max = 1;
        for(int i = pairs.length-1;i >= 0;i--){
            int[] pair = pairs[i];
            longestCount.put(pair,1);
            for(int j = i+1;j < pairs.length;j++){
                if(pairs[j][0] > pair[1]){
                    longestCount.put(pair,Math.max(longestCount.get(pair),longestCount.get(pairs[j]) + 1));
                    max = Math.max(max,longestCount.get(pair));
                }
            }
        }
        return max;
    }
}
