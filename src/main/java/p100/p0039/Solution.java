package p100.p0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/16 23:31
 */
public class Solution {
    int[] candidates;
    List<List<Integer>> ans = new ArrayList<>();
    int target;

    // 自己的解法，有问题。。。
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        int i = 0;
        for (int candidate : candidates) {
            List<Integer> list = new ArrayList<>();
            list.add(candidate);
            if(candidate < target){
                List<Integer> integers = searchCombination(candidate,i);
                if(integers != null){
                    list.addAll(integers);
                    ans.add(list);
                }
            }else if(candidate == target){
                ans.add(list);
                break;
            }
            i++;
        }
        return ans;
    }

    private List<Integer> searchCombination(int candidate,int index) {
        for (int i = index; i < candidates.length; i++) {
            List<Integer> currComb = new ArrayList<>();
            currComb.add(candidates[i]);
            int currCandidate = candidates[i] + candidate;
            if (target == currCandidate) {
                return currComb;
            } else if (target < currCandidate) {
                return null;
            } else {
                if ((target -  currCandidate)% candidates[i] == 0) {
                    for (int i1 = 0; i1 < (target -  currCandidate) / candidates[i]; i1++) {
                        currComb.add(candidates[i]);
                    }
                    return currComb;
                } else {
                    List<Integer> list = searchCombination(currCandidate,index);
                    if(list != null){
                        currComb.addAll(list);
                        return currComb;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
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
