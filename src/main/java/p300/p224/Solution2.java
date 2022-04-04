package p300.p224;

import java.util.LinkedList;
import java.util.Stack;

/**
 */
public class Solution2 {

    Stack<Integer> stack;
    int curr;
    int n;
    String s;
    public int calculate(String s) {
        Stack<Integer> prestack = stack;
        int precurr = curr;
        int pren = n;
        String pres = this.s;
        this.s = s;
        this.n = s.length();
        this.stack = new Stack<>();
        this.curr = 0;
        while(curr < n){
            char c = s.charAt(curr);
            if(isNum(c)){
                int num = readNum();
                stack.push(num);
            }else if(c == ' '){
                curr++;
            }else if(c == '('){
                int left = 1;
                int start = curr+1;
                curr++;
                while(curr < n && left != 0){
                    if(s.charAt(curr) == ')'){
                        left--;
                    }else if(s.charAt(curr) == '('){
                        left++;
                    }
                    curr++;
                }
                stack.push(calculate(s.substring(start,curr-1)));
            }else if(c == '+'){
                curr++;
                readExpr();
                doCal(c);
            }else if(c == '-'){
                curr++;
                readExpr();
                doCal(c);
            }
        }
        int ret = stack.pop();
        stack = prestack;
        curr = precurr;
        n = pren;
        this.s = pres;
        return ret;
    }

    void doCal(char op){
        if(op == '-'){
            if(stack.size() > 1){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else{
                stack.push(-stack.pop());
            }
        }else if(op == '+'){
            stack.push(stack.pop() + stack.pop());
        }
    }

    void readExpr(){
        while(curr < n){
            if(isNum(s.charAt(curr))){
                stack.push(readNum());
                return;
            }else if(s.charAt(curr) == '('){
                int left = 1;
                int start = curr+1;
                curr++;
                while(curr < n && left != 0){
                    if(s.charAt(curr) == ')'){
                        left--;
                    }else if(s.charAt(curr) == '('){
                        left++;
                    }
                    curr++;
                }
                stack.push(calculate(s.substring(start,curr-1)));
                return;
            }else if(s.charAt(curr) == ' '){
                curr++;
            }else if(s.charAt(curr) == '-'){
                stack.push(-stack.pop());
            }
        }
    }

    boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    int readNum(){
        int start = curr;
        while(curr < n && isNum(s.charAt(curr))){
            curr++;
        }
        return Integer.parseInt(s.substring(start,curr));
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().calculate("(1+(4+5+2)-3)+(6+8)"));
//        System.out.println(new Solution2().calculate("-4+5+2-3"));
    }

}
