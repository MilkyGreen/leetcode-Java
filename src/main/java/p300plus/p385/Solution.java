package p300plus.p385;

public class Solution {
    int idx = 0;
    String s;
    int len;
    public NestedInteger deserialize(String s) {
        this.s = s;
        this.len = s.length();
        return deserialize();
    }

    public NestedInteger deserialize() {
        NestedInteger ret = new NestedInteger();
        if(s.charAt(idx) == '['){
            idx++;
            if(s.charAt(idx) == ']'){
                idx++;
                return ret;
            }
            NestedInteger ni = deserialize();
            ret.add(ni);
            if(s.charAt(idx) == ','){
                while(idx < len && s.charAt(idx) == ','){
                    idx++;
                    ret.add(deserialize());
                }
            }
            idx++;
        }else if(isNum(s.charAt(idx)) || '-' == s.charAt(idx)){
            return getInt();
        }
        
        return ret;
    }

    public NestedInteger getInt() {
        boolean neg = false;
        if(s.charAt(idx) == '-'){
            neg = true;
            idx++;
        }
        int start = idx;
        while(idx < len && isNum(s.charAt(idx))){
            idx++;
        }
        int i = Integer.parseInt(s.substring(start,idx));
        if(neg){
            i = -i;
        }
        return new NestedInteger(i);
    }

    boolean isNum(char c){
        return c >= '0' && c <= '9';
    }
}
