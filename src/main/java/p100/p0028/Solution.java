package p100.p0028;

/**
 * Created by simon on 2020/2/23.
 */
public class Solution {

    public int strStr(String haystack, String needle) {

        if(needle == null || needle.equals("")){
            return 0;
        }
        if("".equals(haystack)){
            return -1;
        }

        char[] target = needle.toCharArray();
        int left = 0;
        int right = target.length - 1;
        while (left<haystack.length() && right<haystack.length()){
            String substring = haystack.substring(left, right + 1);
            if(substring.equals(needle)){
                return left;
            }else{
                left++;
                right++;
            }

        }
        return -1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.strStr("mississippi","issip"));
    }
}
