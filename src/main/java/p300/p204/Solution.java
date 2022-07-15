package p300.p204;

public class Solution {
    public int countPrimes(int n) {
        int ret = 0;
        // 1 means prime, 0 means not
        int[] p = new int[n];
        Arrays.fill(p,1);
        for(int i = 2;i < n;i++){
            // finded a prime, its multiplier must not a prime,mark them
            if(p[i] == 1){
                ret++;
                if((long)i * i < n){
                    // marks from i*i ,the i*(i-1) was marked already(by i-1)
                    for(int j = i*i;j < n;j=j+i){
                        p[j] = 0;
                    }
                }
            }
        }

        return ret;
        

    }
}
