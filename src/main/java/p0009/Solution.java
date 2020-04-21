package p0009;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/27 9:57
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String origin = Integer.valueOf(x).toString();
        int left = 0;
        int right = origin.length() - 1;
        while (left <= right){
            if(origin.charAt(left) == origin.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int x = 2147483647;
        System.out.println(new Solution().isPalindrome(x));
    }

}
