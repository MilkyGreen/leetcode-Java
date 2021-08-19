package p300.p224;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>
 */
public class Solution {

    /*public int calculate2(String s) {
        char[] ss = s.toCharArray();
        Stack<String> stack = new Stack<>();

        for(char c : ss){
            if(')' != c && ' '!= c){
                if(c >='0' && c <= '9' && stack.size() > 0 && isNum(stack.peek())){
                    String n = stack.pop();
                    int num = Integer.parseInt(n) * 10 + c-'0';
                    stack.push(num+"");
                }else{
                    stack.push(c+"");
                }
            }else if(')' == c){
                LinkedList<String> list = new LinkedList<>();
                while(true){
                    String ele = stack.pop();
                    if("(".equals(ele)){
                        stack.push(calculate(list)+"");
                        break;
                    }
                    list.addFirst(ele);
                }
            }
        }
        if(stack.size() == 1){
            return Integer.parseInt(stack.pop());
        }
        LinkedList<String> list = new LinkedList<>();
        while(stack.size() > 0){
            list.addFirst(stack.pop());
        }
        return calculate(list);
    }

    private boolean isNum2(String s){
        return !"(".equals(s) && !")".equals(s) && !"+".equals(s)&& !"-".equals(s)&& !" ".equals(s);
    }

    private int calculate2(LinkedList<String> list){
        while(list.size() > 1){
            String s = list.removeFirst();
            if("+".equals(s) || "-".equals(s)){
                int l = Integer.parseInt(list.removeFirst());
                list.addFirst(("+".equals(s) ? l : -l)+"");
                continue;
            }
            int l = Integer.parseInt(s);
            String op = list.removeFirst();
            int r = Integer.parseInt(list.removeFirst());
            int v = "+".equals(op) ? l+r : l - r;
            list.addFirst(v+"");
        }
        return Integer.parseInt(list.getFirst());
    }*/




    LinkedList<Integer> nums = new LinkedList<>();
    LinkedList<Character> ops = new LinkedList<>();
    public int calculate(String s) {
        s = s.replace(" ","");
        int l = s.length();
        int i = 0;
        while(i < l){
            char c = s.charAt(i);
            if('(' == c){
                ops.addLast(c);
                i++;
            }else if(')' == c){
                while(ops.peekLast() != '('){
                    calc();
                }
                ops.removeLast();
                i++;
            }else if(isNum(c)){
                int num = 0;
                int j = i;
                while(j < l && isNum(s.charAt(j))){
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                nums.addLast(num);
                i = j;
            }else{
                if(nums.size() == 0 || (i > 0 && s.charAt(i - 1) == '(')){
                    nums.addLast(0);
                }
                if(ops.size() > 0 && ops.peekLast() != '('){
                    calc();
                }
                ops.addLast(c);
                i++;
            }
        }
        while(nums.size() > 1){
            calc();
        }
        return nums.getLast();
    }

    public void calc(){
        if(nums.size() < 2){
            return;
        }
        if(ops.size() < 1){
            return;
        }
        int a = nums.removeLast();
        int b = nums.removeLast();
        char op = ops.removeLast();
        nums.addLast('+' == op ? b + a : b - a);
    }

    private boolean isNum(char s){
        return Character.isDigit(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate(" -2 + 1"));
    }
}
