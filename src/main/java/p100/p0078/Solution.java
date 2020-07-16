package p100.p0078;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * <p>
 * Copyright: Copyright (c) 2020/7/16 19:56
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    // 本轮子集长度
    List<List<Integer>> result = new LinkedList<>();
    int nums[];
    /**
     * 思路：回溯的做法，这次把每一步的结果都返回
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        traceBack(0,new LinkedList<>());
        return result;
    }

    private void traceBack(int first,LinkedList<Integer> curr){
        result.add(new LinkedList<>(curr));
        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            traceBack(i + 1,curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution.subsets(nums);
    }

}
