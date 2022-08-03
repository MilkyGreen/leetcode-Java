package p300plus.p316;

public class Solution {
    public String removeDuplicateLetters(String s) {
        char[] cs = s.toCharArray();
        Map<Character,Integer> count = new HashMap<>();
        for(char c : cs){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        Set<Character> seen = new HashSet<>();
        LinkedList<Character> stack = new LinkedList<>();
        for(char c : cs){
            if(!seen.contains(c)){
                while(stack.size() > 0 && c < stack.peekLast() && count.get(stack.peekLast()) > 0){
                    seen.remove(stack.removeLast());
                }
                stack.addLast(c);
                seen.add(c);
            }
            count.put(c,count.get(c) - 1);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
