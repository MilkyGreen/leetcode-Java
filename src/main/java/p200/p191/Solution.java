package p200.p191;

public class Solution {
    public int hammingWeight(int n) {

        int ret = 0;
        int one = 1;
        while(n != 0){
            ret += (n & one);
            // 注意这里需要无符号右移，不然第一位的符号位会一直在前面
            n = (n >>> 1);
        }
        return ret;

    }
}
