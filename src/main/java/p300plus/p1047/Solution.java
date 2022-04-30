package p300plus.p1047;

public class Solution {
    public String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for(int i =0;i < cs.length;i++){
            if(stack.size() > 0 && stack.peek() == cs[i]){
                stack.pop();
            }else{
                stack.push(cs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
