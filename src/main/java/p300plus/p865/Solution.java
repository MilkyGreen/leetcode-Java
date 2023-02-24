package p300plus.p865;

public class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        for(char c : s.toCharArray()){
            if(c == ')'){
                curr = stack.pop() + Math.max(2*curr,1);
            }else{
                stack.push(curr);
                curr=0;
            }
        }
        return curr;
        
    }
}
