package p300plus;

/**
 * <p>
 */
public class Solution {

    public boolean isNumber(String s) {
        s = s.trim();
        if(s.equals("")){
            return false;
        }
        int e = -1;
        for(int i =0;i<s.length();i++){
            if('e' == s.charAt(i) || 'E' == s.charAt(i)){
                e = i;
                break;
            }
        }
        if(e == -1){
            if(isInt(s)){
                return true;
            }
            if(isF(s)){
                return true;
            }
        }else{
            if(e == 0 || e == s.length()-1){
                return false;
            }else{
                String pre = s.substring(0,e);
                String post = s.substring(e+1);
                return (isF(pre) || isInt(pre)) && isInt(post);
            }
        }
        return false;
    }

    private boolean isInt(String s){
        if(s == null|| s.equals("")){
            return false;
        }
        if(s.startsWith("-") || s.startsWith("+")){
            return isInt(s.substring(1));
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) > '9' || s.charAt(i) < '0' || s.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }

    private boolean isF(String s){
        if(s == null || s.equals("") || s.length() == 1){
            return false;
        }
        if(s.startsWith("-") || s.startsWith("+")){
            return isF(s.substring(1));
        }
        int dot = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '.'){
                dot = i;
            }else if(s.charAt(i) > '9' || s.charAt(i) < '0' || s.charAt(i) == ' '){
                return false;
            }
        }
        if(dot == -1){
            return false;
        }
        if(dot == 0){
            return isInt(s.substring(1));
        }
        if(dot == s.length()-1){
            return isInt(s.substring(0,dot));
        }
        return isInt(s.substring(dot+1)) && isInt(s.substring(0,dot));
    }

    public static void main(String[] args) {
        new Solution().isNumber("0.8");
    }

}
