package p300plus.p1576;

/**
 */
public class Solution {

    public String modifyString(String s) {

        // 每次只替换跟字母相邻的？号
        while(s.contains("?")){
            char[] cs = s.toCharArray();
            if(cs.length == 1){
                return "a";
            }

            for(int i = 0;i<cs.length;i++){
                if(cs[i] == '?'){
                    if(i == 0 && cs[i+1] != '?'){
                        cs[i] = getChar(cs[i+1],null);
                    }
                    if(i == cs.length-1 && cs[i-1] != '?'){
                        cs[i] = getChar(cs[i-1],null);
                    }
                    if(i >0 && i<cs.length-1 && (cs[i-1] != '?' || cs[i+1] != '?')){
                        cs[i] = getChar(cs[i+1], cs[i-1]);
                    }
                }
            }
            s = new String(cs);
        }
        return s;
    }

    public char getChar(Character a,Character b){
        if(a == '?'){
            a = null;
        }
        if(b != null && b == '?'){
            b = null;
        }
        if(a == null){
            a = b;
            b = null;
        }
        if(b == null){
            char r = 'a';
            while(true){
                if(r != a){
                    return r;
                }
                r = (char)(r+1);
            }
        }else{
            char r = 'a';
            while(true){

                if(r != a && r != b){
                    return r;
                }
                r = (char)(r+1);
            }
        }
    }



}
