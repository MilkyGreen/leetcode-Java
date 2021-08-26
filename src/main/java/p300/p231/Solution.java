package p300.p231;

/**
 * <p>
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        if(n < 0){
            return false;
        }
        String s = Integer.toBinaryString(n);
        if(s.startsWith("1") && n == (1 << (s.length()-1))){
                return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(-16));
        System.out.println(Math.pow(2,-2));
    }

}
