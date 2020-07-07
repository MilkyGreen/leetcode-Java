package p100.p0005;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/23 18:10
 */
public class Solution {

    public static void main(String[] args){
        String s = "babad";
        Solution mySolution = new Solution();
        System.out.println(mySolution.longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString(); //字符串倒置
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i; //以 i 位置结尾的字符
                }

            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

}
