package p300plus.p405;

public class Solution {
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        while(num != 0){
            int n = num & ((1 << 4) - 1);
            if(n >= 10){
                sb.append((char)('a' + (n - 10)));
            }else{
                sb.append(n);
            }
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}
