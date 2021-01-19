package p200.p125;

/**
 * //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * //
 * // 说明：本题中，我们将空字符串定义为有效的回文串。
 * //
 * // 示例 1:
 * //
 * // 输入: "A man, a plan, a canal: Panama"
 * //输出: true
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: "race a car"
 * //输出: false
 * //
 */
public class Solution {

    public boolean isPalindrome(String s) {
        if("".equals(s)){
            return true;
        }
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        // 去除干扰字符
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if ((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z')) {
                sb.append(aChar);
            }
        }
        System.out.println(sb);
        String s1 = sb.toString();
        int i = 0;
        int l = s1.length() - 1;
        while (i<l){
            if(s1.charAt(i) == s1.charAt(l)){
                i++;
                l--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
    }

}
