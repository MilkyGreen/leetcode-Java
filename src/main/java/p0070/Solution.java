package p0070;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * <p>
 * Copyright: Copyright (c) 2020/6/2 22:32
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 思路：每一步都可以选择一步或两步，最后如果等于n，则路径有效，大于n无效。 -> 44超时了，需要优化。
     * 优化思路：递归中会有很多重复计算，用数组缓存结果。 -》通过
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 目前的位置
        int location = 0;
        int[] memo = new int[n+1];
        return climb(location+1,n,memo)+climb(location+2,n,memo);
    }
    public int climb(int location,int n,int[] memo){
        if(location == n){
            memo[location] = 1;
            return 1;
        }else if(location < n){
            if(memo[location] > 0){
                return memo[location];
            }
            memo[location] = climb(location+1,n,memo)+climb(location+2,n,memo);
            return memo[location];
        }else {
//            memo[location] = 0;
            return 0;
        }
    }

    public static void main(String[] args){
        System.out.println(new Solution().climbStairs(44));
    }
}
