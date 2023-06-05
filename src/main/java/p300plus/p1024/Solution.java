package p300plus.p1024;

public class Solution {
    public int videoStitching(int[][] clips, int time) {
        int step = 0;
        Arrays.sort(clips,(a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });

        int idx = 0;
        int currMaxTime = 0;
        
        while(currMaxTime < time && idx < clips.length){
            int stepMax = currMaxTime;
            while(idx < clips.length && clips[idx][0] <= currMaxTime){
                stepMax = Math.max(stepMax,clips[idx][1]);
                idx++;
            }
            if(currMaxTime == stepMax){
                break;
            }
            currMaxTime = stepMax;
            step++;
        }

        if(currMaxTime < time){
            return -1;
        }
        return step;
    }
}
