package p200.p166;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        Map<Long,Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        if(a * b < 0){
            sb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(String.valueOf(a / b));
        if(a % b == 0){
            return sb.toString();
        }
        sb.append(".");
        a %= b;
        while(a != 0){
            map.put(a,sb.length());
            a *= 10;
            sb.append(String.valueOf(a / b));
            a %= b;
            if(map.containsKey(a)){
                return String.format("%s(%s)",sb.substring(0,map.get(a)),sb.substring(map.get(a)));
            }
        }
        return sb.toString();
    }
}
