package p300.p279;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 */
public class Solution {


    public int numSquares(int n) {
        ArrayList<Integer> list = new ArrayList<>(); // 小于n的所有的平方数
        for (int i = 1; i <= n; i++) {
            if(i * i <= n){
                list.add(i*i);
            }
        }
        if(list.size() == 0){
            return 0;
        }
        // dp[i][j] 代表到第i个数，和为j的元素最小数量
        int[][] dp = new int[list.size()][n+1];
        // 处理第一个数
        for (int j = 1; j <= n; j++) {
            Integer a = list.get(0);
            int num = -1;
            for(int k = 1;k*a <= j;k++){
                if(k*a == j){ // 选k次a，能凑出来j，k就是最小数字
                    num = k;
                }
            }
            dp[0][j] = num;
        }

        for (int i = 1; i < list.size(); i++) {
            Integer num = list.get(i);
            for (int j = 0; j <= n; j++) {
                int a = dp[i - 1][j]; // 不选自己，等于前一个节点最新数
                // 选自己，看看选几次。且选择的时候，前面的也要是能凑成的才行。
                for(int k = 1;k*num<=j;k++){
                    if(dp[i-1][j-k*num] != -1){ // 选了k次，前面的数要能凑成才行
                        a = Math.min(a,dp[i-1][j-k*num]+k);
                    }
                }
                dp[i][j] = a;
            }
        }
        return dp[list.size()-1][n];
    }

    public int numSquares3(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j=1;i>=j*j;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(new Solution().numSquares3(13));
    }

    int INF = -1;
    public int numSquares2(int n) {
        // 预处理出所有可能用到的「完全平方数」
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            list.add(idx * idx);
            idx++;
        }

        // f[i][j] 代表考虑前 i 个物品，凑出 j 所使用到的最小元素个数
        int len = list.size();
        int[][] f = new int[len][n + 1];

        // 处理第一个数的情况
        for (int j = 0; j <= n; j++) {
            int t = list.get(0);
            int k = j / t;
            if (k * t == j) { // 只有容量为第一个数的整数倍的才能凑出
                f[0][j] = k;
            } else { // 其余则为无效值
                f[0][j] = INF;
            }
        }

        // 处理剩余数的情况
        for (int i = 1; i < len; i++) {
            int t = list.get(i);
            for (int j = 0; j <= n; j++) {
                // 对于不选第 i 个数的情况
                f[i][j] = f[i - 1][j];
                // 对于选 k 次第 i 个数的情况
                for (int k = 1; k * t <= j; k++) {
                    // 能够选择 k 个 t 的前提是剩余的数字 j - k * t 也能被凑出
                    // 使用 0x3f3f3f3f 作为最大值（预留累加空间）可以省去该判断
                    if (f[i - 1][j - k * t] != INF) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - k * t] + k);
                    }
                }

            }
        }
        return f[len - 1][n];
    }

}
