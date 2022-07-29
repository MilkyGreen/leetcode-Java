package p300.p227;

public class Solution {
    char[] cs;
    int next = 0;
    int len;

    String plus = "plus";
    String minus = "minus";
    String multi = "multi";
    String div = "div";
    Map<Character,Integer> pri = new HashMap<>();

    List<Object> ops = new ArrayList<>();

    public int calculate(String s) {
        pri.put('+',0);
        pri.put('-',0);
        pri.put('*',1);
        pri.put('/',1);
        s = s.replace(" ","");
        if(s.startsWith("-")){
            s = "0" + s;
        }
        cs = s.toCharArray();
        len = cs.length;

        int left = readNum();
        ops.add(left);
        while(next < len){
            readExpr();
        }
        
        Stack<Integer> stack = new Stack<>();
        for(Object op : ops){
            if(op.equals(plus)){
                stack.push(stack.pop() + stack.pop());
            }else if(op.equals(minus)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if(op.equals(multi)){
                stack.push(stack.pop() * stack.pop());
            }else if(op.equals(div)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }else{
                stack.push((int)op);
            }
        }
        return stack.pop();
    }

    void readExpr(){
        char op = cs[next];
        next++;
        int right = readNum();
        ops.add(right);
        while(next < len && pri.get(cs[next]) > pri.get(op)){
            readExpr();
        }
        if(op == '+'){
            ops.add(plus);
        }else if(op == '-'){
            ops.add(minus);
        }else if(op == '*'){
            ops.add(multi);
        }else if(op == '/'){
            ops.add(div);
        }
    }

    boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    int readNum(){
        int i = cs[next] - '0';
        next++;
        while(next < len && isNum(cs[next])){
            i = i * 10 + (cs[next] - '0');
            next++;
        }
        return i;
    }
}
