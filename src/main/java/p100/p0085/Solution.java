package p100.p0085;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 */
public class Solution {

    /**
     * 思路：利用栈依次记录数组下标，遇到小于栈顶高度的值，就可以计算栈顶的面积，因为前后高度比其小的元素都确定了。
     * 一个技巧是数组前后先插入个0，就不用处理最大高度在数组收尾的问题。
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        if(heights.length == 0){
            return 0;
        }

        if(heights.length == 1){
            return heights[0];
        }
        int length = heights.length;
        int res = 0;

        // 数组前后各插入0
        int[] newHeights = new int[length+2];
        System.arraycopy(heights,0,newHeights,1,length);
        newHeights[0] = 0;
        newHeights[length + 1] = 0;

        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        // 先入栈个0，确保stack不会空
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            // 如果栈顶元素比i位置高，说明可以计算栈顶的面积了
            while (heights[i] < heights[stack.peek()]){
                // 栈顶的高度
                int currHeight = heights[stack.pop()];
                // 新栈顶就是上个比currHeight小的位置
                Integer lastSmall = stack.peek();
                // 计算面积
                int area = (i - lastSmall-1)*currHeight;
                res = Math.max(res,area);
            }
            // 新元素入栈，由于上面的while处理，这时栈里是没有比当前位置高的元素了，所以栈里面的元素是从小到大有序的。
            stack.push(i);
        }
        return res;
    }

}
