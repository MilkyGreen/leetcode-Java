package p300plus.p1288;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int ret = 0;
        Arrays.sort(intervals,(a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });

        int rmax = intervals[0][1];

        for(int i = 1;i < intervals.length;i++){
            int[] curr = intervals[i];
            if(curr[1] <= rmax){
                ret++;
            }else{
                rmax = curr[1];
            }
        }
        return intervals.length - ret;
    }
}
