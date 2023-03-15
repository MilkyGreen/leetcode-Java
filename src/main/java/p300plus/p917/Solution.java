package p300plus.p917;

public class Solution {
    public String reverseOnlyLetters(String s) {
        int l = 0;
        int len = s.length();
        char[] cs = s.toCharArray();
        while(l < len && !isLetter(s.charAt(l))){
            l++;
        }

        int r = len - 1;
        while(r >= 0 && !isLetter(s.charAt(r))){
            r--;
        }

        while(l < r){
            char t = cs[l];
            cs[l] = cs[r];
            cs[r] = t;

            l++;
            r--;

            while(l < len && !isLetter(s.charAt(l))){
                l++;
            }

            while(r >= 0 && !isLetter(s.charAt(r))){
                r--;
            }
        }
        return new String(cs);
    }

    boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
