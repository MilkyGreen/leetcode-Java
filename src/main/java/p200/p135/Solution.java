package p200.p135;

/**
 * //老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * //
 * // 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * //
 * //
 * // 每个孩子至少分配到 1 个糖果。
 * // 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * //
 * //
 * // 那么这样下来，老师至少需要准备多少颗糖果呢？
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：[1,0,2]
 * //输出：5
 * //解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * //
 * //
 */
public class Solution {

    /**
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {

        int count = 1; //需要发的糖果总数,先给第一个发1颗
        int increaseCount = 1; // 当前上升序列长度 把第一个加上
        int decreaseCount = 0; // 当前下降序列长度
        int pre = 1; // 上个个糖果数量
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1; // 相当的就发一个
                count += pre; // 加上当前的
                increaseCount = pre; // 如果一直升序，pre就是升序数量，如果是从相当或降序恢复，则从1开始
                decreaseCount = 0;// 降序归0
            } else {
                decreaseCount++; // 降序数量加一
                if (decreaseCount == increaseCount) { // 如果降序和上个升序相当，要把升序的最大算成降序，给他发糖，不然可能会小于降序的开始位置
                    decreaseCount++;
                }
                count += decreaseCount; // 给降序的每个人都发个糖，集体涨薪。
                pre = 1; // 下次的升序又从1开始了，糖也是1个。
            }
        }
        return count;
    }

















    public int candy1(int[] ratings) {
        int pre = 1, increaseCount = 1, decreaseCount = 0,count = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                increaseCount = pre;
                count+= pre;
                decreaseCount = 0;
            }else {
                decreaseCount++;
                if(decreaseCount == increaseCount){
                    decreaseCount++;
                }
                count+=decreaseCount;
                pre = 1;
            }
        }
        return count;
    }

}
