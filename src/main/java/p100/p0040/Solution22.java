package p100.p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 */
public class Solution22 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int l = candidates.length;
        Arrays.sort(candidates);
        boolean[] flags = new boolean[l];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates,target,flags,0,path,0);

        return res;
    }

    void dfs(int[] candidates, int target,boolean[] flags,int idx,LinkedList<Integer> path,int sum){
        if(sum == target){
            res.add(new ArrayList(path));
            return;
        }
        if(sum > target || idx == candidates.length){
            return;
        }
        if(idx != 0 && candidates[idx] == candidates[idx-1] && !flags[idx -1]){
            return;
        }
        for(int i = idx;i<candidates.length;i++){
            sum += candidates[i];
            path.add(candidates[i]);
            flags[i] = true;

            dfs(candidates,target,flags,i,path,sum);

            sum -= candidates[i];
            path.removeLast();
            flags[i] = false;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        new Solution22().combinationSum2(nums,8);
    }
}
