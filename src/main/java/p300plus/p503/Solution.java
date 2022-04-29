package p300plus.p503;

public class Solution {
    // 单调栈。遍历两次数组，第二次的时候不需要往栈里放了
    public int[] nextGreaterElements(int[] nums) {
        int l = nums.length;
        int[] ret = new int[l];
        // Arrays.fill(ret,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < l;i++){
            while(stack.size() > 0 && nums[i] > nums[stack.peek()]){
                int smallIdx = stack.pop();
                ret[smallIdx] = nums[i];
            }
            stack.push(i);
        }
        for(int i = 0;i < l && stack.size() > 0;i++){
            while(stack.size() > 0 && nums[i] > nums[stack.peek()]){
                int smallIdx = stack.pop();
                ret[smallIdx] = nums[i];
            }
        }
        while(stack.size() > 0){
            ret[stack.pop()] = -1;
        }
        return ret;
    }
}
