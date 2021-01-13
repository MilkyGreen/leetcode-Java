package p200.p121;

/**
 * //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * //
 * // 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * //
 * // 注意：你不能在买入股票前卖出股票。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * // 输入: [7,1,5,3,6,4]
 * //输出: 5
 * //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: [7,6,4,3,1]
 * //输出: 0
 * //解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * //
 */
public class Solution {


    /**
     * 思路：遍历，依次选取每个元素作为买入，后面作为卖出，计算利润 -> 超时了
     *
     * 新思路：
     * 记录【今天之前买入的最小值】
     * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     * 比较【每天的最大获利】，取最大值即可
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i];
            max = Math.max(max,sell - min);
            min = Math.min(min,sell);
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int i = new Solution().maxProfit(prices);
        System.out.println(i);
    }
}
