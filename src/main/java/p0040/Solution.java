package p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/17 23:47
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null){
            return ans;
        }
        Arrays.sort(candidates);
        dfs(candidates,target,0,new Stack<>());
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int[] candidates, int target, int index, Stack<Integer> pre){
        if(target == 0){
            ArrayList<Integer> list = new ArrayList<>(pre);
            ans.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(candidates[i] > target){
                return;
            }

            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }

            pre.push(candidates[i]);
            dfs(candidates, target-candidates[i], i+1, pre);
            pre.pop();
        }
    }

}
