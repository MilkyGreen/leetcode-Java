package weekcontest.N057;

import java.util.*;

/**
 * <p>
 */
public class Solution3 {


    public List<List<Long>> splitPainting(int[][] segments) {
        HashMap<Integer, List<Long>> map = new HashMap<>();
        int end = 0;
        int start = segments[0][0]-1;
        for (int i = 0; i < segments.length; i++) {
            int[] segment = segments[i];
            end = Math.max(end, segment[1] - 2);
            start = Math.min(start, segment[0] - 1);
            for (int j = segment[0] - 1; j <= segment[1] - 2; j++) {
                List<Long> list = map.getOrDefault(j, new ArrayList<>());
                list.add((long)segment[2]);
                map.put(j,list);
            }
        }
        map.values().forEach(list ->{
            list.sort(Comparator.comparingLong(o -> o));
        });

        List<Long> lastColor = null;
        List<List<Long>> ans = new ArrayList<>();
        Long s = (long)start;
        for (int i = start; i <= end+1; i++) {
            List<Long> currList = map.get(i);
            if (lastColor != null) {
                if (currList == null || !sameColor(currList,lastColor)) {
                    ArrayList<Long> list = new ArrayList<>();
                    list.add(s + 1);
                    list.add(i + 1L);
                    list.add(sumList(lastColor));
                    ans.add(list);
                    s = (long) i;
                }
            }else {
                s = (long) i;
            }
            lastColor = currList;
        }
        return ans;
    }

    private boolean sameColor(List<Long> a,List<Long> b){
        if(a.size() != b.size()){
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) != b.get(i)){
                return false;
            }
        }
        return true;
    }

    private Long sumList(List<Long> list){
        Long sum = 0L;
        for (Long aLong : list) {
            sum += aLong;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] segments = new int[4][3];
        int[] a = new int[]{2,4,5};
        int[] b = new int[]{2,4,7};
        int[] c = new int[]{4,7,1};
        int[] d = new int[]{4,7,11};
        segments[0] = a;
        segments[1] = b;
        segments[2] = c;
        segments[3] = d;

        new Solution3().splitPainting(segments);
    }
}
