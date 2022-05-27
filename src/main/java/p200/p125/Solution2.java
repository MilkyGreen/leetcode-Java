package p200.p125;

public class Solution2 {
    // 从两边依次对比字符是否相等。移动的时候忽略掉非字母和数字，注意不要越界
    public boolean isPalindrome(String s) {
        s = s.trim();
        if("".equals(s)){
            return true;
        }
        s = s.toLowerCase();
        int len = s.length();
        int left = 0;
        int right = len - 1;
        while(left <= right){
            while(left < len && !isAlphacNumberc(s.charAt(left))){
                left++;
            }

            while(right >= 0 && !isAlphacNumberc(s.charAt(right))){
                right--;
            }

            if(left >= right){
                return true;
            }

            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    boolean isAlphacNumberc(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
