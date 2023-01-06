package p200.p190;

public class Solution {
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        while(s.length() < 32){
            s = "0"+s;
        }

        int ret = 0;
        for(int i = 0;i < 32;i++){
            if(s.charAt(i) == '1'){
                ret |= (1 << i);
            }
        }
        return ret;
    }
}
