package p300plus.p1457;

import java.util.Stack;

public class Solution {
    public int[] finalPrices(int[] prices) {

        int len = prices.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < len;i++){
            while(stack.size() > 0 && prices[stack.peek()] >= prices[i]){
                int idx = stack.pop();
                res[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }

        while(stack.size() > 0){
            res[stack.peek()] = prices[stack.pop()];
        }

        return res;
    }
}
