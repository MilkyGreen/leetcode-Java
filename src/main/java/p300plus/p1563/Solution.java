package p300plus.p1563;

/**
 * <p>
 */
public class Solution {

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n]; // dp[i][j] 代表alice再i到j区间能取得的最大值
        int[][] s = new int[n][n]; // s[i][j] 代表i到j中间的和

        for(int i=0;i<n;i++){
            s[i][i] = stoneValue[i];
        }
        for(int k=2;k<=n;k++){ // 求各个区间和（其实可以用前缀和来做）
            for(int i=0;i+k-1<n;i++){
                s[i][i+k-1] = s[i][i+k-2] + stoneValue[i+k-1];
            }
        }

        for(int i=0;i<n-1;i++){
            dp[i][i+1] = Math.min(stoneValue[i],stoneValue[i+1]);
        }
        for(int k=3;k<=n;k++){ // k代表区间长度
            for(int i=0;i+k-1<n;i++){ // i代表开始位置，结束位置是i+k-1
                int max = 0;
                for(int j = i;j<i+k-1;j++){ // j代表各个区间内每个可选的分割处，依次尝试，找到最大值
                    int leftSum = s[i][j];
                    int rightSUm = s[j+1][i+k-1];
                    if(leftSum > rightSUm){
                        max = Math.max(max,dp[j+1][i+k-1]+rightSUm);
                    }else if(rightSUm > leftSum){
                        max = Math.max(max,dp[i][j]+leftSum);
                    }else{
                        max = Math.max(max,Math.max(dp[i][j]+leftSum,dp[j+1][i+k-1]+rightSUm));
                    }
                }
                dp[i][i+k-1] = max;
            }
        }
        return dp[0][n-1];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,8,2,4,6,3,5,1,7};
        new Solution().stoneGameV(nums);
    }

}
