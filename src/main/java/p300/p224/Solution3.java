package p300.p224;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 */
public class Solution3 {

    // 所有指令
    List<Object> list = new ArrayList<>();
    String PLUS = "PLUS";
    String MINUS = "MINUS";
    String NEG = "NEG";

    int curr = 0;
    int n;
    String s;
    char[] cs;
    public int calculate(String s) {
        s = s.replace(" ","");
        this.s = s;
        this.cs = s.toCharArray();
        this.n = s.length();
        readExpr();
        Stack<Integer> stack = new Stack<>();
        for(Object o : list){
            if(o.equals(PLUS)){
                stack.push(stack.pop() + stack.pop());
            }else if(o.equals(MINUS)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if(o.equals(NEG)){
                stack.push(-stack.pop());
            }else{
                stack.push((int)o);
            }
        }
        return stack.pop();
    }

    void readExpr(){
        boolean hasNum = false;
        while(curr < n){
            char c = cs[curr];
            if(c == '('){
                curr++;
                readGroup();
                hasNum = true;
            }else if(c == ')'){
                return;
            }else if(isNum(c)){
                list.add(readNum());
                hasNum = true;
            }else if(c == '+'){
                curr++;
                if(cs[curr] == '('){
                    curr++;
                    readGroup();
                }else{
                    list.add(readNum());
                }
                list.add(PLUS);
            }else if(c == '-'){
                curr++;
                if(cs[curr] == '('){
                    curr++;
                    readGroup();
                }else{
                    list.add(readNum());
                }
                if(hasNum){
                    list.add(MINUS);
                }else{
                    list.add(NEG);
                }
            }
        }
    }

    void readGroup(){
        readExpr();
        curr++;
    }

    boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    int readNum(){
        int num = cs[curr] - '0';
        curr++;
        while(curr < n && isNum(cs[curr])){
            num = num*10 + cs[curr] - '0';
            curr++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
