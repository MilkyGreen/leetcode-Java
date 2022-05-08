package p100.p0045;

public class Solution2 {
    // 这题的关键在于求步数，而是不求具体路径。利用贪心算法，每步尽量走最远
    // left 到 right 代表每一步能到达的区间，每走一步计算出这一步能到达的最远距离maxIdx，left+1 到 maxIdx 作为下一步的起点区间，直到maxIdx超过最后一个元素。
    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int maxIdx = 0;
        int left = 0;
        int right = 0;
        while(maxIdx < n - 1){
            for(int j = left;j <= right;j++){
                maxIdx = Math.max(maxIdx,j + nums[j]);
            }
            left = right + 1;
            right = maxIdx;
            step++;
        }
        return step;
    }
}
