package p200.p171;

public class Solution {
    public int titleToNumber(String columnTitle) {
        int ret = 0;
        for(char c : columnTitle.toCharArray()){
            ret = ret * 26 + (c - 'A' + 1);
        }
        return ret;
    }
}
