package p300plus.p1190;

public class Solution {
    int idx = 0;
    public String reverseParentheses(String s) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(idx < cs.length){
            if(cs[idx] == '('){
                String reversedStr = reverseBeginWithParentheses(cs);
                sb.append(reversedStr);
            }else{
                sb.append(cs[idx]);
                idx++;
            }
        }
        return sb.toString();
    }

    public String reverseBeginWithParentheses(char[] cs) {
        StringBuilder sb = new StringBuilder();
        idx++;
        while(cs[idx] != ')'){
            if(cs[idx] == '('){
                String reversedStr = reverseBeginWithParentheses(cs);
                sb.append(reversedStr);
            }else{
                sb.append(cs[idx]);
                idx++;
            }
        }
        idx++;
        
        return sb.reverse().toString();
    }
}
