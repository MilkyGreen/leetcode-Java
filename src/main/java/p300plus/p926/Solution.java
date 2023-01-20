package p300plus.p926;

public class Solution {
    public int minFlipsMonoIncr(String s) {
        int ret = 0;
        int m = 0;
        int len = s.length();
        for(int i = 0;i < len;i++){
            if(s.charAt(i) == '0'){
                m++;
            }
        }
        ret = m;
        for(int i = 0;i < len;i++){
            if(s.charAt(i) == '0'){
                ret = Math.min(ret,--m);
            }else{
                m++;
            }
        }
        return ret;
    }
}
