package p100.p0014;

/**
 * Created by simon on 2020/2/9.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");
        if(strs.length == 0){
            return result.toString();
        }
        String firstString = strs[0];
        int length = firstString.length();

        out:for (int i = 0; i < length; i++) {
            char c = firstString.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if(i > str.length() - 1){
                    break out;
                }
                char c1 = str.charAt(i);
                if(c != c1){
                    break out;
                }
            }
            result.append(c);
        }
        return result.length() == 0 ? "" :result.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

}
