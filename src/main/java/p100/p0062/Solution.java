package p100.p0062;

/**
 * @author liyunmeng
 * @Description: 不同路径
 * 题目：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 思路1：观察发现，任意起点的路径数，等于它右边方块路径数加下面方块路径数，即(m,n) = （m-1,n）+ (m,n-1)
 * 而且(1,n) = (m,1) = 1，利用这两点来递归求解直到m或n等于1时返回1。 -> case 51,9 超时了
 *
 * 思路2：延续思路1，增加dp数组缓存中间结果，省掉一些重复计算。并且(m,n)其实和(n,m)是相等的，计算过(m,n)之后(n,m)可以直接获取
 * -> 通过，击败100% java解题。 厉害了，第一次完全自主思路用动态规划解题，:）
 * @Date 2020/4/29 14:15
 */
public class Solution {
    // 缓存计算结果
    int[][] dp;
    public int uniquePaths(int m, int n) {

        // m n 可以互换，长度取最大的一个
        this.dp = new int[Math.max(m,n)+1][Math.max(m,n)+1];
        // 遇到1直接返回
        if(m == 1 || n == 1){
            return 1;
        }
        return getPaths(m ,n);
    }

    public int getPaths(int m, int n){
        // 看看有没有计算过
        if(dp[m][n] != 0 ){
            return dp[m][n];
        }
        // m n 换个顺序再查下
        if(dp[n][m] != 0 ){
            return dp[n][m];
        }
        // 遇到1直接返回
        if(m == 1 || n == 1){
            dp[m][n] = 1;
            return 1;
        }
        // (m,n) = （m-1,n）+ (m,n-1)
        dp[m][n] = getPaths(m - 1,n)+getPaths(m,n-1);
        return dp[m][n];
    }


    public static void main(String[] args){
        System.out.println(new Solution().uniquePaths(51,9));
    }
}
