package p300.p202;

public class Solution {
    Map<Long,Long> map = new HashMap<>();
    public boolean isHappy(int n) {
        return isHappy((long)n);
    }

    public boolean isHappy(long n) {
        if(n == 1){
            return true;
        }
        if(map.containsKey(n)){
            return false;
        }
        map.put(n,n);
        long newN = 0;
        while(n != 0){
            newN += (n % 10) * (n % 10);
            n /= 10;
        }
        if(newN == 1){
            return true;
        }else{
            return isHappy(newN);
        }
    }
}
