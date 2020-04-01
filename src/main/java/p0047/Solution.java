package p0047;

import java.util.*;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/4/1 22:05
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int l = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(l == 0){
            return ans;
        }
        boolean[] used = new boolean[l];
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        dfs(path,used,nums,ans);
        return ans;
    }

    private void dfs(Deque<Integer> path,boolean[] used,int[] nums,List<List<Integer>> ans){
        if(nums.length == path.size()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                if(i > 0 && nums[i] == nums[i-1] && !used[i -1]){
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(path, used, nums, ans);
                path.removeLast();
                used[i] = false;
            }
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,1,3};
        List<List<Integer>> permute = solution.permuteUnique(nums);
        permute.forEach(list ->{
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println("");
        });
    }
}
