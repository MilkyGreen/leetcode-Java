package weekcontest.NO55;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 */
public class Solution3 {
    long ans = 0;
    long currSum = 0;
    // 思路：dfs -> 超时了，优化，判断自己处于偶数还是奇数，偶数的话选小于自己的，奇数的话选大于自己的
    public long maxAlternatingSum2(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            dfs(path,nums,i);
        }
        return ans;
    }

    private void dfs(Deque<Integer> path,int[] nums,int curr){
        if(curr == nums.length){
            return;
        }
        int num = nums[curr];
        path.addLast(num);
        int currIndex = path.size()-1;
        currSum += currIndex%2 == 0 ? num : -num;
        ans = Math.max(ans,currSum);
        for (int i = curr+1; i < nums.length; i++) {
            if(currIndex%2 == 0){
                if(nums[curr] > nums[i]){
                    dfs(path,nums,i);
                }
            }else {
                if(nums[curr] < nums[i]){
                    dfs(path,nums,i);
                }
            }
        }
        path.removeLast();
        currSum += currIndex%2 == 0 ? -num : num;
    }



    public long maxAlternatingSum(int[] nums) {
        long even = nums[0]; // 第i个数，选择的子序列是偶数的最大值
        long odd = 0; // 第i个数，选择的子序列是奇数的最大值
        for (int i=1;i< nums.length;i++){
            even = Math.max(odd+nums[i],even); // 选择i，奇数加
            odd = Math.max(even - nums[i],odd); // 选择i，偶数减
        }
        return even;
    }


    public static void main(String[] args){
        int[] nums = {5,6,7,8};
        System.out.println(new Solution3().maxAlternatingSum(nums));
    }

}
