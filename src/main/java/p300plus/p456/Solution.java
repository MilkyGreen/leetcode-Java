package p300plus.p456;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();
        // i k j
        // var last is j
        int last = Integer.MIN_VALUE;
        for(int i = n-1;i >=0;i--){
            // there must be a num greater then last in the stack. and at last`s left side in nums
            if(nums[i] < last){
                return true;
            }
            while(stack.size() > 0 && stack.peek() < nums[i]){
                // trying to maximize last
                last = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
