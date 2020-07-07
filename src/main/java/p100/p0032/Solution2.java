package p100.p0032;

import java.util.Stack;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/4 23:28
 */
public class Solution2 {

    public int longestValidParentheses(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }
                ans = Math.max(ans,i - stack.peek());
            }
        }
        return ans;
    }

}
