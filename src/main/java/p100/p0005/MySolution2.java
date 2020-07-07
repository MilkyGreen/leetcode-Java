package p100.p0005;

/**
 * @author liyunmeng
 * @Description: 中心扩展法
 * @Date 2019/12/24 10:44
 */
public class MySolution2 {

    public static void main(String[] args){
        String s = "adbab";
        String s1 = "baabad";
        String s2 = "bbbbb";
        MySolution2 mySolution = new MySolution2();
        System.out.println(mySolution.longestPalindrome(s2));
    }

    public String longestPalindrome(String s){
        if("".equals(s)){
            return "";
        }
        int start = 0,end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > maxLen){
                maxLen  =len;
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int expandAroundCenter(String s,int L,int R){
        while (L >= 0 && R <= s.length()-1 && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }

}
