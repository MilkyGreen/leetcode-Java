package p100.p0058;

/**
 * @author liyunmeng
 * @Description: length-of-last-word
 * easy
 * 解题里没啥人用split，是我犯规了吗。。。
 * @Date 2020/4/26 16:46
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        String[] s1 = s.split(" ");
        int l = s1.length;

        for (int i = l -1; i >= 0; i--) {
            String s2 = s1[i];
            if(!"".equals(s2)){
                return s2.length();
            }
        }

        return 0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World  "));
    }

}
