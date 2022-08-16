package p300plus.p459;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len == 1){
            return false;
        }
        char startChar = s.charAt(0);
        outter : for(int i = 1;i < len;i++){
            if(s.charAt(i) == startChar){
                int subLen = i;
                if(len % subLen == 0){
                    String sub = s.substring(0,i);
                    int subStart = i;
                    int subEnd = subStart + subLen;
                    
                    while(subEnd <= len){
                        if(!sub.equals(s.substring(subStart, subEnd))){
                            continue outter;
                        }
                        subStart = subEnd;
                        subEnd = subStart + subLen;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
