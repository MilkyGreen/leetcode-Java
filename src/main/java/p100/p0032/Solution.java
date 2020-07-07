package p100.p0032;

import java.util.Stack;

/**
 * Created by simon on 2020/3/2.
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int ans = 0;
        if(s == null || "".equals(s)){
            return ans;
        }

        int begin = 0;
        while (begin< s.length() - 1){
            if(')' == s.charAt(begin)){
                begin++;
            }else{
                Stack<Character> stack = new Stack<>();
                stack.push('(');
                int end = begin + 1;
                while (end < s.length()){
                    char endChar = s.charAt(end);
                    if(')' == endChar){
                        if(stack.size() == 0){
                            break;
                        }
                        stack.pop();
                        if(stack.size() == 0){
                            int result = end - begin + 1;
                            ans = Math.max(ans,result);
                        }
                    }else{
                        stack.push('(');
                    }
                    end++;
                }
                begin++;
                if(stack.size() == s.length()){
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
