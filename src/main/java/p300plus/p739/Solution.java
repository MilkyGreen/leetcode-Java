package p300plus.p739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ret = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            int num = temperatures[i];
            while(stack.size() != 0 && temperatures[stack.peek()] < num){
                ret[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ret;
    }
}
