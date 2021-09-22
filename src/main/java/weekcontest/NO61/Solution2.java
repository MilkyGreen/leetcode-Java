package weekcontest.NO61;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] changed = new int[]{0,0,0,0};
        int[] originalArray = new Solution2().findOriginalArray(changed);
        System.out.println(originalArray);
    }


    public int[] findOriginalArray(int[] changed) {

        int l = changed.length;
        if(l % 2 != 0){
            return new int[0];
        }
        int[] res = new int[l/2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : changed){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        Arrays.sort(changed);
        int oi = 0;
        for(int n : changed){
            Integer c = map.get(n);
            if(map.containsKey(n*2)){
                Integer o = map.get(n*2);
                if((n == 0 && c >= 2) || (n != 0 && c > 0 && o > 0)){
                    res[oi] = n;
                    oi++;
                    map.put(n,c-1);
                    map.put(n*2,map.get(n*2)-1);
                }
            }
        }
        if(oi == l/2){
            return res;
        }else{
            return new int[0];
        }



    }
}
