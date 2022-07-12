package p300plus.p528;

public class Solution {
    int sum = 0;
    
    // 每个i代表了一个区间，如果随机数落到该区间里，则返回i
    int[][] interval;
    public Solution(int[] w) {
        interval = new int[w.length][2];
        for(int n : w){
            sum += n;
        }
        int idx = 0;
        for(int i = 0;i < w.length;i++){
            int n = w[i];
            int[] range = new int[2];
            range[0] = idx;
            range[1] = idx + n - 1;
            interval[i] = range;
            idx = idx + n;
        }
    }
    
    public int pickIndex() {
        int r = new Random().nextInt(sum);
        int left = 0;
        int right = interval.length - 1;
        // 二分查找合适的区间
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            int[] range = interval[mid];
            if(range[0] > r){
                right = mid - 1;
            }else if(range[1] < r){
                left = mid + 1;
            }else if(range[0] <= r && range[1] >= r){
                return mid;
            }
        }
        return 0;
    }
}
