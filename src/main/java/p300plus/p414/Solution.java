package p300plus.p414;

public class Solution {
    public int thirdMax(int[] nums) {
        long f = (long)Integer.MIN_VALUE-1;
        long s = (long)Integer.MIN_VALUE-1;
        long t = (long)Integer.MIN_VALUE-1;

        for(int n : nums){
            if(n == f || n == s || n == t){
                continue;
            }
            if(n > f){
                t = s;
                s = f;
                f = n;
            }else if(n > s){
                t = s;
                s = n;
            }else if(n > t){
                t = n;
            }
        }
        return t == (long)Integer.MIN_VALUE-1 ? (int)f : (int)t;
    }
}
