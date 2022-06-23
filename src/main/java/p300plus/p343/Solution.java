package p300plus.p343;

public class Solution {
    public int integerBreak(int n) {
        
        if(n <= 3){
            return n-1;
        }
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2;i <= n;i++){
            f[i] = i;
            for(int j = 1;j < i/2+1;j++){
                f[i] = Math.max(f[i],f[j] * f[i-j]);
            }
        }
        return f[n];
    }
}
