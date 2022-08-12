package p100.p0028;

public class Solution2 {
    public int strStr(String haystack, String needle) {
        if(needle == null || "".equals(needle)){
            return 0;
        }

        int ret = -1;
        for(int i = 0;i <= haystack.length() - needle.length();i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(needle.equals(haystack.substring(i,i + needle.length()))){
                    return i;
                }
            }
        }
        return ret;
    }
}
