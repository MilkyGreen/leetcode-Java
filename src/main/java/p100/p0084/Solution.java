package p100.p0084;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * //
 * // 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * //
 * //
 * //
 * //
 * //
 * // 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * //
 * //
 * //
 * //
 * //
 * // 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 */
public class Solution {

    /**
     * 思路：暴力枚举，依次以每个柱子为高，向两边查找大于等于当前高度的left和right，遇到更小的值就停止。
     * 当前面积就是 高度*right-left+1 ，记录遍历过程中最大的面积，返回即可。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        if(heights.length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < heights.length; i++) {

            // 向左边找大于等于i位置数字的位置left
            int left = i;
            // 注意这里比较的是 left -1 和i，符合之后left才会--;
            while (left > 0 && heights[left -1] >= heights[i]){
                left--;
            }

            // 向右找，逻辑同上。注意边界问题。也是right + 1比较符合之后才++的
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]){
                right++;
            }

            // 计算面积
            int area = (right - left + 1) * heights[i];
            // 每次与当前最大比较
            result = Math.max(result,area);
        }

        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(nums));
    }

}
