package p300plus.p647;

public class Solution {
    public int countSubstrings(String s) {
        int ret = 0;
        int len = s.length();
        ret += len;
        for(int i = 0;i < len;i++){
            if(i > 0 && i < len - 1){
                int left = i-1;
                int right = i+1;
                while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                    ret++;
                    left--;
                    right++;
                }
            }

            if(i < len - 1){
                int left = i;
                int right = i+1;
                while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                    ret++;
                    left--;
                    right++;
                }
            }
        }
        return ret;
    }
}
