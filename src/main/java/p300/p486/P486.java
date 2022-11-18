package p300.p486;

/**
 * <p>
 * Copyright: Copyright (c) 2022/11/18 10:49
 * <p>
 * Company: ClickPaaS
 * <p>
 *
 * @author yunmeng.li@clickpaas.com
 * @version 1.0.0
 */
public class P486 {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        // f[i][j] means palyer1's max score int i to j when first pick
        int[][] f = new int[n][n];

        // s[i][j] means palyer1's max score int i to j when second pick
        int[][] s = new int[n][n];
        int sum = 0;
        for(int i = 0;i < n;i++){
            f[i][i] = nums[i];
            sum += nums[i];
        }

        for(int i = 0;i < n-1;i++){
            f[i][i+1] = Math.max(nums[i],nums[i+1]);
            s[i][i+1] = Math.min(nums[i],nums[i+1]);
        }

        for(int len = 3;len <= n;len++){

            for(int i = 0,j = i + len - 1;j < n;i++,j++){
                f[i][j] = Math.max(nums[i]+s[i+1][j],nums[j] + s[i][j-1]);
                s[i][j] = Math.min(f[i][j-1],f[i+1][j]);
            }
        }

        return f[0][n-1] * 2 >= sum;
    }

    public static void main(String[] args) {
        new P486().PredictTheWinner(new int[]{2,4,55,6,8});
    }

}
