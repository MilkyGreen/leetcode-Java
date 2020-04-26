package p0057;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author liyunmeng
 * @Description: 插入区间，思路同56，先插入一个元素
 * @Date 2020/4/26 16:33
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int l = intervals.length;
        intervals = Arrays.copyOf(intervals, l + 1);
        intervals[l] = newInterval;

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(deque.size() == 0){
                deque.push(interval[0]);
                deque.push(interval[1]);
            }else{
                //上个区间的结尾
                Integer lastend = deque.pop();
                //上个区间的开始
                Integer laststart = deque.pop();

                if(lastend < interval[0]){
                    // 没有交集
                    deque.push(laststart);
                    deque.push(lastend);
                    deque.push(interval[0]);
                    deque.push(interval[1]);
                }else{
                    // 有交集，合并区间
                    // 开始取最小值
                    deque.push(Math.min(laststart,interval[0]));
                    // 结束取最大值
                    deque.push(Math.max(lastend,interval[1]));
                }
            }
        }

        int[][] ans = new int[deque.size()/2][2];
        int i = 0;
        while (deque.size() > 0){
            int[] curr = new int[2];
            curr[0] = deque.pollLast();
            curr[1] = deque.pollLast();
            ans[i] = curr;
            i++;
        }
        return ans;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] nums = {{1,3},{6,9}};
        int[] intv = {2,5};
        int[][] merge = solution.insert(nums,intv);
        System.out.println(merge);
    }

}
