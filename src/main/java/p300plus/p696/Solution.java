package p300plus.p696;

public class Solution {
    public int countBinarySubstrings(String s) {
        int ret = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int lastCount = -1;
        int idx = 0;
        while(idx < n){
            char c = s.charAt(idx);
            idx++;
            int count = 1;
            while(idx < n && c == s.charAt(idx)){
                idx++;
                count++;
            }
            if(lastCount != -1){
                ret += Math.min(lastCount,count);
            }
            lastCount = count;
        }
        return ret;

    }
}
