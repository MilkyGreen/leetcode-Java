package p300plus.p452;

public class Solution {
    // 按右边界排序，每次选择右边界最小的作为发射位置
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a1,a2) -> a1[1] < a2[1] ? -1 : 1);
        int ret = 1;
        int pre = points[0][1];
        for(int i = 1;i < points.length;i++){
            if(points[i][0] > pre){
                ret++;
                pre = points[i][1];
            }
        }
        return ret;
    }
}
