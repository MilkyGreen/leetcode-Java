package p300plus.p946;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> pushSet = new HashSet<>();

        int i = 0;
        int j = 0;
        while(i < popped.length){
            int p = popped[i];
            if(pushSet.contains(p)){
                if(stack.pop() != p){
                    return false;
                }
            }else{
                while(j < pushed.length && !pushSet.contains(p)){
                    pushSet.add(pushed[j]);
                    stack.push(pushed[j]);
                    j++;
                }
                stack.pop();
            }
            i++;
        }
        return true;
    }
}
