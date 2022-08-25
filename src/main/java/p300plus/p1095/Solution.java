package p300plus.p1095;

public class Solution {
    /**
     * 三次二分，第一次找峰值，剩下两次找目标
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int l = 0;
        int r = len - 1;
        while(l < r){
            int mid = l + ((r - l) >> 1);
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        int peek = l;
        int v = bs(target, mountainArr, 0, peek, true);
        if(v != -1){
            return v;
        }
        return bs(target, mountainArr, peek+1, len - 1, false);
    }

    int bs(int target, MountainArray mountainArr,int l,int r,boolean isLeft){
        if(!isLeft){
            target *= -1;
        }
        while(l <= r){
            int mid = ((r - l) >> 1) + l;
            int n = isLeft ? mountainArr.get(mid) : mountainArr.get(mid) * -1;
            if(n == target){
                return mid;
            }else if(n > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
