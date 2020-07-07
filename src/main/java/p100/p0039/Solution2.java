package p100.p0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/17 9:57
 */
public class Solution2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null){
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates,target,0,new Stack<Integer>());
        return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    private void dfs(int[] candidates, int target, int index, Stack<Integer> pre){
        if(target == 0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(candidates[i] > target){
                break;
            }
            pre.push(candidates[i]);
            dfs(candidates,target - candidates[i],i,pre);
            pre.pop();
        }
    }

    public static void main(String[] args){
        Solution2 solution = new Solution2();
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println(" ");
        }
    }
}
