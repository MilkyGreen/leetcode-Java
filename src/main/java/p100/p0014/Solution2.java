package p100.p0014;

public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0){
            return "";
        }
        // 先获得前两个字符串的前缀，然后拿这个前缀依次和后的字符串取前缀，最后获得的就是整个字符串数组的前缀
        String ret = strs[0];
        if(n == 1){
            return ret;
        }
        for(int i = 1;i < n; i++){
            if("".equals(ret)){
                return "";
            }
            ret = cp(ret,strs[i]);
        }
        
        return ret;
    }

    public String cp(String prefix,String s){
        int min = Math.min(prefix.length(),s.length());
        for(int i = 0; i < min; i++){
            if(prefix.charAt(i) != s.charAt(i)){
                return prefix.substring(0,i);
            }
        }
        return prefix.length() > s.length() ? s : prefix;
    }
}
