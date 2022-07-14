package p300plus.p875;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p : piles){
            max = Math.max(max,p);
        }
        int left = 1;
        int right = max;
        int ret = right;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            int count = count(piles,mid);
            if(count <= h){
                ret = mid;  // h小时内可以吃完
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return ret;
    }

    int count(int[] piles,int k){
        int time = 0;
        for(int p : piles){
            int t = p / k;
            if(p % k != 0){
                t++;
            }
            time += t;
        }
        return time;
    }
}
