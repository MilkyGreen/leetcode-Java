package p300plus.p1328;

public class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }

        int len = palindrome.length();
        int cantReplaceIdx = -1;
        if(len % 2 == 1){
            cantReplaceIdx = len / 2;
        }

        char[] cs = palindrome.toCharArray();
        for(int i = 0;i < len;i++){
            if(i != cantReplaceIdx){
                if(cs[i] != 'a'){
                    cs[i] = 'a';
                    break;
                }

                if(i == len - 1){
                    cs[i] = 'b';
                }
            }
        }
        return new String(cs);
    }
}
