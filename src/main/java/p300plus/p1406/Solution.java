package p300plus.p1406;

/**
 */
public class Solution {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] f = new int[n+1]; // f[i]代表alice先手在i~n堆里能获取的最大分数。
        int[] s = new int[n+1]; // s[i]代表alice后手在i~n堆里能获取的最大分数。

        int sum = 0;
        for(int i=n-1;i>n-2;i--){
            sum += stoneValue[i];
            f[i] = sum;
        }

        for(int i = n-2;i>=0;i--){
            sum += stoneValue[i];
            int subsum = 0;
            for(int k=0;k<3 && i + k < n;k++){
                subsum += stoneValue[i+k];
                if(k == 0){ // 考虑到有负数，第一次直接赋值，不能max
                    f[i] = subsum + s[i + k + 1];
                }else{
                    f[i] = Math.max(f[i],subsum + s[i + k + 1]);
                }

                if(k == 0){ // s[i] 默认是0，第一次要直接赋值
                    s[i] = f[i+k+1];
                }else{
                    s[i] = Math.min(f[i+k+1],s[i]); // 对手选过之后剩下的最小值
                }
            }
        }

        if(f[0] > sum - f[0]){
            return "Alice";
        }else if(f[0] < sum - f[0]){
            return "Bob";
        }else{
            return "Tie";
        }

    }

    public static void main(String[] args) {
        int[] ss = new int[]{1,2,3,7};
        new Solution().stoneGameIII(ss);
    }

}
