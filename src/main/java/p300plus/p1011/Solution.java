package p300plus.p1011;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int right = 0;
        int left = 0;
        for(int w : weights){
            right += w;
            left = Math.max(left,w);
        }

        while(left < right){
            int need = 1;
            int curr = 0;
            int mid = left + (right - left) / 2;
            for(int w : weights){
                if(curr + w > mid){
                    curr = 0;
                    need++;
                }
                curr += w;
            }
            if(need > days){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
