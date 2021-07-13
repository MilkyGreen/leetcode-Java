package p300plus.p1575;

/**
 */
public class Solution {

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int mod = (int)Math.pow(10,9) + 7;
        int l = locations.length;
        int[][] dp = new int[l][fuel+1];

        // 初始化
        for (int i = 0; i <= fuel; i++) {
            dp[finish][i] = 1;
        }

        for (int i = 0; i <= fuel; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < l; k++) {
                    if(j != k){
                        int need = Math.abs(locations[j] - locations[k]);
                        if(i >= need){
                            dp[j][i] += dp[k][i-need];
                            dp[j][i] %= mod;
                        }
                    }
                }
            }
        }
        return dp[start][fuel];
    }

}
