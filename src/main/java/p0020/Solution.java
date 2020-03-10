package p0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by simon on 2020/2/17.
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<String,String> map = new HashMap<String, String>(){{
            put(")","(");
            put("}","{");
            put("]","[");
        }};

        String leftString = "({[";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(String.valueOf(c))){
                if(!stack.empty()){
                    Character pop = stack.pop();
                    if(!String.valueOf(pop).equals(map.get(String.valueOf(c)))){
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                stack.push(c);

            }
        }
        return stack.empty();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isValid("{[][]}"));
    }

}
