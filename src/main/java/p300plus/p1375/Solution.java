package p300plus.p1375;

public class Solution {
    public int numTimesAllBlue(int[] flips) {
        
        int fliped = 0;
        int maxFlipedIdx = -1;
        int ret = 0;
        for(int f : flips){
            fliped++;
            maxFlipedIdx = Math.max(maxFlipedIdx,f);
            if(fliped == maxFlipedIdx){
                ret++;
            }
        }
        return ret;
    }
}
