package p300plus.p977;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(;i < nums.length;i++){
            if(nums[i] < 0){
                stack.push(nums[i] * nums[i]);
            }else{
                break;
            }
        }

        int idx = 0;
        while(stack.size() > 0 && i < nums.length){
            if(stack.peek() < nums[i] * nums[i]){
                nums[idx] = stack.pop();
            }else{
                nums[idx] = nums[i] * nums[i];
                i++;
            }
            idx++;
        }
        while(stack.size() > 0){
            nums[idx] = stack.pop();
            idx++;
        }

        while(i < nums.length){
            nums[idx] = nums[i] * nums[i];
            i++;
            idx++;
        }

        return nums;
    }
}
