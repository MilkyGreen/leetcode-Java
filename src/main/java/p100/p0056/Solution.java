package p100.p0056;

import java.util.*;

/**
 * @author liyunmeng
 * @Description: 合并区间
 * @Date 2020/4/23 13:58
 */
public class Solution {

    public int[][] merge(int[][] intervals) {

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
//        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int[][] nums = {{1,4},{0,2},{3,5}};
        int[][] merge = solution.merge(nums);
        System.out.println(merge);
    }

}
