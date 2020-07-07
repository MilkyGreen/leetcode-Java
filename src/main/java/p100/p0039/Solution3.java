package p100.p0039;

import java.util.*;

/**
 * @author liyunmeng
 * @Description: 动态规划法:https://leetcode-cn.com/problems/combination-sum/solution/chao-qiang-gifzhu-ni-shi-yong-dong-tai-gui-hua-qiu/
 * @Date 2020/3/17 22:52
 */
public class Solution3 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        Arrays.sort(candidates);
        for (int i = 1; i <= target; i++) {
            map.put(i,new HashSet<>());
            for (int j = 0; j < candidates.length&&i>=candidates[j]; j++) {
                if(candidates[j] == i){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(candidates[j]);
                    map.get(i).add(temp);
                }else if(candidates[j] < i){
                    int key = i - candidates[j];
                    Set<List<Integer>> listSet = map.get(key);
                    if(listSet != null){
                        for (List<Integer> integers : listSet) {
                            List<Integer> temp = new ArrayList<>(integers);
                            temp.add(candidates[j]);
                            Collections.sort(temp);
                            map.get(i).add(temp);
                        }
                    }
                }
            }
        }
        result.addAll(map.get(target));
        return result;
    }

}
