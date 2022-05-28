package p100.p0084;

public class Solution2 {
    // 确定一个柱子两边比他小的柱子，就可以确定以这个柱子为高的面积
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return heights[0];
        }

        int[] nh = new int[len+2];
        nh[0] = 0;
        System.arraycopy(heights,0,nh,1,len);
        nh[len+1] = 0;
        len += 2;
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1;i < len;i++){
            while(nh[i] < nh[stack.peek()]){
                int currHeight = nh[stack.pop()];
                int w = i - stack.peek() - 1;
                ret = Math.max(ret,currHeight * w);
            }
            stack.push(i);
        }
        return ret;
    }
}
