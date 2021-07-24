package weekcontest.N057;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 */
public class Solution3 {


    public List<List<Long>> splitPainting(int[][] segments) {
        HashMap<Integer, Long> map = new HashMap<>();
        int end = 0;
        for (int i = 0; i < segments.length; i++) {
            int[] segment = segments[i];
            end = Math.max(end, segment[1] - 1);
            for (int j = segment[0] - 1; j < segment[1] - 1; j++) {
                map.put(j, map.getOrDefault(j, 0L) + segment[2]);
            }
        }

        Long lastColor = 0L;
        List<List<Long>> ans = new ArrayList<>();
        Long s = 0L;
        Long e = 0L;
        for (int i = 0; i <= end; i++) {
            Long aLong = map.get(i);
            if (lastColor != 0L) {
                if (lastColor != aLong) {
                    ArrayList<Long> list = new ArrayList<>();
                    list.add(s + 1);
                    list.add(e + 1);
                    list.add(lastColor);
                    ans.add(list);
                    s = e;
                }
            }
            e++;
            lastColor = aLong;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
