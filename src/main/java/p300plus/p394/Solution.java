package p300plus.p394;

import weekcontest.N057.Solution3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version 1.0.0
 */
public class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int l = s.length();
        String ans = "";
        for(int i = 0;i<l;i++){
            char c = s.charAt(i);
            if(c == ']'){
                String sub = "";
                char p = stack.pop();
                while(p != '['){
                    sub += p;
                    p = stack.pop();
                }
                String sn = stack.pop()+"";
                while(stack.size() > 0 && stack.peek() >= '0' && stack.peek() <= '9'){
                    sn = stack.pop() + sn;
                }
                addChars(stack,sub,Integer.valueOf(sn));
            }else{
                stack.push(c);
            }
        }
        int m = stack.size();
        for(int i = 0;i<m;i++){
            ans += stack.removeLast();
        }
        return ans;
    }

    private void addChars(Deque<Character> stack, String sub, int n){
        for (int i = 0;i<n;i++){
            for (int j = sub.length() - 1;j>=0;j--){
                stack.push(sub.charAt(j));
            }
        }
    }

    public static void main(String[] args) {
        new Solution().decodeString("abc3[cd]xyz");
    }
}
