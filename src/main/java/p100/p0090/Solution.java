package p100.p0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Solution {

    /**
     * 思路：先排序，再全排列遍历，重复的元素只遍历一次
     */



    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

//        res.add(new ArrayList<>());
        if(nums.length == 0){
            return res;
        }

        Arrays.sort(nums);// 排个序
        boolean[] used = new boolean[nums[nums.length-1]+1];//记录元素是否遍历过了
        LinkedList<Integer> path = new LinkedList<>();
        trackBack(res,0,nums,used,path);

        return res;
    }

    private void trackBack(List<List<Integer>> res, int first, int[] nums, boolean[] used, LinkedList<Integer> path){
        res.add(new LinkedList<>(path));
        for (int i = first; i < nums.length; i++) {
            /*if(path.size() == 0){
                if(used[nums[i]]){
                    continue;
                }else {
                    used[nums[i]] = true;
                }
            }*/

            // 关键是每一轮遇到重复过的都要跳过
            if (i > first && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            trackBack(res,i+1,nums,used,path);
            path.removeLast();
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        lists.size();
    }

}
