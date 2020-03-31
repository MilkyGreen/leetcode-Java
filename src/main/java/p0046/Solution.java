package p0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/31 23:13
 */
public class Solution {


    public List<List<Integer>> permute(int[] nums) {
        int l = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(l == 0){
            return ans;
        }

        for (int i = 0; i < l; i++) {
            int num = nums[i];
            List<Integer> list = new ArrayList<>();
            list.add(num);
            nextNum(ans,list,nums);
        }
        return ans;
    }

    public void nextNum(List<List<Integer>> ans,List<Integer> list,int[] nums){
        if(list.size() == nums.length){
            ans.add(list);
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(!list.contains(nums[i])){
                    List<Integer> newList = new ArrayList<>();
                    newList.addAll(list);
                    newList.add(nums[i]);
                    nextNum(ans,newList,nums);
                }
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        permute.forEach(list ->{
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println("");
        });
    }



}
