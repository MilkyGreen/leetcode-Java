package p300plus.p735;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int a : asteroids){
            if(a > 0 || stack.size() == 0 || stack.peek() < 0){
                stack.push(a);
            }else{
                int value = a;
                while(stack.size() > 0 && stack.peek() > 0){
                    int pre = stack.pop();
                    if(pre > -a){
                        value = pre;
                        break;
                    }else if(pre == -a){
                        value = 1001;
                        break;
                    }else{
                        value = a;
                    }
                }
                if(value != 1001){
                    stack.push(value);
                }
            }
        }
        int[] ret = new int[stack.size()];
        int i = 0;
        while(stack.size() > 0){
            ret[i] = stack.removeLast();
            i++;
        }
        return ret;
    }
}
